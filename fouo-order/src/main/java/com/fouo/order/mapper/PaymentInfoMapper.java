package com.fouo.order.mapper;

import com.fouo.order.entity.PaymentInfo;
import com.fouo.order.vo.PaymentInfoVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 支付信息表 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface PaymentInfoMapper extends BaseMapper<PaymentInfo> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param paymentInfo
	 * @return
	 */
	List<PaymentInfoVO> selectPaymentInfoPage(IPage page, PaymentInfoVO paymentInfo);

}
