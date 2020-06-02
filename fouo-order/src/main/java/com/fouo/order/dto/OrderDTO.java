package com.fouo.order.dto;

import com.fouo.order.entity.Order;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderDTO extends Order {
	private static final long serialVersionUID = 1L;

}
