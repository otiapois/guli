package com.fouo.order.vo;

import com.fouo.order.entity.Order;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 订单视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OrderVO对象", description = "订单")
public class OrderVO extends Order {
	private static final long serialVersionUID = 1L;

}
