package com.fouo.order.vo;

import com.fouo.order.entity.OrderReturnReason;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 退货原因视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OrderReturnReasonVO对象", description = "退货原因")
public class OrderReturnReasonVO extends OrderReturnReason {
	private static final long serialVersionUID = 1L;

}
