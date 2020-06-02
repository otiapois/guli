package com.fouo.order.service;

import com.fouo.order.entity.RefundInfo;
import com.fouo.order.vo.RefundInfoVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 退款信息 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IRefundInfoService extends IService<RefundInfo> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param refundInfo
	 * @return
	 */
	IPage<RefundInfoVO> selectRefundInfoPage(IPage<RefundInfoVO> page, RefundInfoVO refundInfo);

}
