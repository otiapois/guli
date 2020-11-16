package com.fouo.ware.service;

import com.fouo.ware.entity.PurchaseDetail;
import com.fouo.ware.vo.PurchaseDetailVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 *  服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IPurchaseDetailService extends IService<PurchaseDetail> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param purchaseDetail
	 * @return
	 */
	IPage<PurchaseDetailVO> selectPurchaseDetailPage(IPage<PurchaseDetailVO> page, PurchaseDetailVO purchaseDetail);

	/**
	 * 根据采购单id获取采购项集合
	 * @param id
	 * @return
	 */
    List<PurchaseDetail> listDetailByPurchaseId(Long id);
}
