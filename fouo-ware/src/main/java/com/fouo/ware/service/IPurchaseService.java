package com.fouo.ware.service;

import com.fouo.ware.entity.Purchase;
import com.fouo.ware.vo.PurchaseDoneVO;
import com.fouo.ware.vo.PurchaseVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * 采购信息 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IPurchaseService extends IService<Purchase> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param purchase
	 * @return
	 */
	IPage<PurchaseVO> selectPurchasePage(IPage<PurchaseVO> page, PurchaseVO purchase);

	/**
	 * 查询未领取的采购单分页
	 * @param page
	 * @param purchase
	 * @return
	 */
    IPage<PurchaseVO> selectUnreceivePurchasePage(IPage<PurchaseVO> page, PurchaseVO purchase);

	/**
	 * 合并采购单
	 * @param merge
	 * @return
	 */
	boolean mergePurchase(PurchaseVO merge);

	/**
	 * 领取采购单
	 * @param ids
	 * @return
	 */
    boolean received(List<Long> ids);

	/**
	 * 完成采购需求
	 * @param doneVO
	 * @return
	 */
	boolean done(PurchaseDoneVO doneVO);
}
