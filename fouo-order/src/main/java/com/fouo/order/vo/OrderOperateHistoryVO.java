package com.fouo.order.vo;

import com.fouo.order.entity.OrderOperateHistory;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 订单操作历史记录视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OrderOperateHistoryVO对象", description = "订单操作历史记录")
public class OrderOperateHistoryVO extends OrderOperateHistory {
	private static final long serialVersionUID = 1L;

}
