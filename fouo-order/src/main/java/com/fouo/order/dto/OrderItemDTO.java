package com.fouo.order.dto;

import com.fouo.order.entity.OrderItem;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单项信息数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderItemDTO extends OrderItem {
	private static final long serialVersionUID = 1L;

}
