package com.fouo.ware.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fouo.ware.entity.PurchaseDetail;
import com.fouo.ware.vo.PurchaseDetailVO;
import com.fouo.ware.mapper.PurchaseDetailMapper;
import com.fouo.ware.service.IPurchaseDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 *  服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class PurchaseDetailServiceImpl extends ServiceImpl<PurchaseDetailMapper, PurchaseDetail> implements IPurchaseDetailService {

	@Override
	public IPage<PurchaseDetailVO> selectPurchaseDetailPage(IPage<PurchaseDetailVO> page, PurchaseDetailVO purchaseDetail) {
		return page.setRecords(baseMapper.selectPurchaseDetailPage(page, purchaseDetail));
	}

	@Override
	public List<PurchaseDetail> listDetailByPurchaseId(Long id) {
		return this.list(new QueryWrapper<PurchaseDetail>().eq("purchase_id", id));
	}

}
