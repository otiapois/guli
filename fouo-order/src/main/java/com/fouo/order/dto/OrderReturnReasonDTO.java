package com.fouo.order.dto;

import com.fouo.order.entity.OrderReturnReason;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 退货原因数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderReturnReasonDTO extends OrderReturnReason {
	private static final long serialVersionUID = 1L;

}
