package com.fouo.ware.service.impl;

import com.fouo.ware.entity.Purchase;
import com.fouo.ware.entity.PurchaseDetail;
import com.fouo.ware.enums.PurchaseDetailStatusEnum;
import com.fouo.ware.enums.PurchaseStatusEnum;
import com.fouo.ware.service.IPurchaseDetailService;
import com.fouo.ware.service.IWareSkuService;
import com.fouo.ware.vo.ItemVO;
import com.fouo.ware.vo.PurchaseDoneVO;
import com.fouo.ware.vo.PurchaseVO;
import com.fouo.ware.mapper.PurchaseMapper;
import com.fouo.ware.service.IPurchaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 采购信息 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements IPurchaseService {

    @Autowired
    private IPurchaseDetailService iPurchaseDetailService;
    @Autowired
    private IWareSkuService iWareSkuService;

    @Override
    public IPage<PurchaseVO> selectPurchasePage(IPage<PurchaseVO> page, PurchaseVO purchase) {
        return page.setRecords(baseMapper.selectPurchasePage(page, purchase));
    }

    @Override
    public IPage<PurchaseVO> selectUnreceivePurchasePage(IPage<PurchaseVO> page, PurchaseVO purchase) {
        return page.setRecords(baseMapper.selectUnreceivePurchasePage(page, purchase));
    }

    @Transactional
    @Override
    public boolean mergePurchase(PurchaseVO merge) {
        Long purchaseId = merge.getPurchaseId();
        //如果采购单为空  怎合并的采购单id为新建后的id
        if (purchaseId == null) {
            Purchase purchase = new Purchase();

            purchase.setCreateTime(LocalDateTime.now());
            purchase.setUpdateTime(LocalDateTime.now());
            purchase.setStatus(PurchaseStatusEnum.CREATED.getCode());

            this.save(purchase);
            purchaseId = purchase.getId();
        }
        List<Long> items = merge.getItems();
        Long finalPurchaseId = purchaseId;

        List<PurchaseDetail> collect = items.stream().map(i -> {
            PurchaseDetail purchaseDetail = new PurchaseDetail();
            purchaseDetail.setId(i);
            purchaseDetail.setPurchaseId(finalPurchaseId);
            purchaseDetail.setStatus(PurchaseDetailStatusEnum.ASSINGED.getCode());
            return purchaseDetail;
        }).collect(Collectors.toList());
        boolean flag = iPurchaseDetailService.updateBatchById(collect);

        Purchase purchase = new Purchase();
        purchase.setId(purchaseId);
        purchase.setUpdateTime(LocalDateTime.now());
        this.updateById(purchase);

        return flag;
    }

    @Override
    public boolean received(List<Long> ids) {
        //确认当前采购单是新建或者已分配状态
        List<Purchase> list = ids.stream().map(id -> {
            Purchase purchase = this.getById(id);
            return purchase;
        }).filter(item -> {
            if (item.getStatus() == PurchaseStatusEnum.CREATED.getCode() ||
                    item.getStatus() == PurchaseStatusEnum.ASSINGED.getCode()
            ) {
                return true;
            }
            return false;
        }).map(item -> {
            item.setStatus(PurchaseStatusEnum.RECEIVED.getCode());
            item.setUpdateTime(LocalDateTime.now());
            return item;
        }).collect(Collectors.toList());
        //改变采购单状态
        if (list != null && list.size() > 0) {
            this.updateBatchById(list);
        }
        //改变采购单采购项的状态
        list.forEach((item) -> {
            List<PurchaseDetail> details = iPurchaseDetailService.listDetailByPurchaseId(item.getId());
            List<PurchaseDetail> newDetails = details.stream().map(entity -> {
                PurchaseDetail purchaseDetail = new PurchaseDetail();
                purchaseDetail.setId(entity.getId());
                purchaseDetail.setStatus(PurchaseStatusEnum.RECEIVED.getCode());
                return purchaseDetail;
            }).collect(Collectors.toList());
            iPurchaseDetailService.updateBatchById(newDetails);
        });
        return true;
    }

    @Override
    public boolean done(PurchaseDoneVO doneVO) {

        Long id = doneVO.getId();
        //改变采购项状态
		Boolean flag = true;
        List<ItemVO> items = doneVO.getItems();

        List<PurchaseDetail> temItems = new ArrayList<>();
        for (ItemVO item:items){
			PurchaseDetail purchaseDetail = new PurchaseDetail();
			if(item.getStatus() == PurchaseDetailStatusEnum.HAS_ERROR.getCode()){
				flag = false;
				purchaseDetail.setStatus(item.getStatus());
			}else{
				purchaseDetail.setStatus(PurchaseDetailStatusEnum.FINISHED.getCode());
                //将成功采购的进行入库
                PurchaseDetail detail = iPurchaseDetailService.getById(item.getItemId());
                iWareSkuService.addStock(detail.getSkuId(),detail.getWareId(),detail.getSkuNum());

			}
			purchaseDetail.setId(item.getItemId());
			temItems.add(purchaseDetail);
        }
        if(temItems !=null && temItems.size()>0){
            iPurchaseDetailService.updateBatchById(temItems);
        }

        //改变采购单状态
        Purchase purchase = new Purchase();
        purchase.setId(id);
        purchase.setStatus(flag?PurchaseStatusEnum.FINISHED.getCode():PurchaseStatusEnum.HAS_ERROR.getCode());
        purchase.setUpdateTime(LocalDateTime.now());



        return false;
    }

}
