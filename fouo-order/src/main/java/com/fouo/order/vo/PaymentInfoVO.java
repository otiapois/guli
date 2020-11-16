package com.fouo.order.vo;

import com.fouo.order.entity.PaymentInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 支付信息表视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "PaymentInfoVO对象", description = "支付信息表")
public class PaymentInfoVO extends PaymentInfo {
	private static final long serialVersionUID = 1L;

}
