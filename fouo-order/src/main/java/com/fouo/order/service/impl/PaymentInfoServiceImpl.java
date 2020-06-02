package com.fouo.order.service.impl;

import com.fouo.order.entity.PaymentInfo;
import com.fouo.order.vo.PaymentInfoVO;
import com.fouo.order.mapper.PaymentInfoMapper;
import com.fouo.order.service.IPaymentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 支付信息表 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfo> implements IPaymentInfoService {

	@Override
	public IPage<PaymentInfoVO> selectPaymentInfoPage(IPage<PaymentInfoVO> page, PaymentInfoVO paymentInfo) {
		return page.setRecords(baseMapper.selectPaymentInfoPage(page, paymentInfo));
	}

}
