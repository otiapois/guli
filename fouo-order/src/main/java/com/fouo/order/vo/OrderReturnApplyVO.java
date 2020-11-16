package com.fouo.order.vo;

import com.fouo.order.entity.OrderReturnApply;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 订单退货申请视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OrderReturnApplyVO对象", description = "订单退货申请")
public class OrderReturnApplyVO extends OrderReturnApply {
	private static final long serialVersionUID = 1L;

}
