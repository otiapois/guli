package com.fouo.ware.service;

import com.fouo.ware.entity.Purchase;
import com.fouo.ware.vo.PurchaseVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

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

}
