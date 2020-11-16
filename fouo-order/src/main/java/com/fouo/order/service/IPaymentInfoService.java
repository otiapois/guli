package com.fouo.order.service;

import com.fouo.order.entity.PaymentInfo;
import com.fouo.order.vo.PaymentInfoVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 支付信息表 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IPaymentInfoService extends IService<PaymentInfo> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param paymentInfo
	 * @return
	 */
	IPage<PaymentInfoVO> selectPaymentInfoPage(IPage<PaymentInfoVO> page, PaymentInfoVO paymentInfo);

}
