package com.fouo.order.dto;

import com.fouo.order.entity.PaymentInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 支付信息表数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentInfoDTO extends PaymentInfo {
	private static final long serialVersionUID = 1L;

}
