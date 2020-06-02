package com.fouo.order.vo;

import com.fouo.order.entity.OrderItem;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 订单项信息视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OrderItemVO对象", description = "订单项信息")
public class OrderItemVO extends OrderItem {
	private static final long serialVersionUID = 1L;

}
