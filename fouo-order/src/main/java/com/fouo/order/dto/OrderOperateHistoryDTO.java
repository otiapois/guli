package com.fouo.order.dto;

import com.fouo.order.entity.OrderOperateHistory;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单操作历史记录数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderOperateHistoryDTO extends OrderOperateHistory {
	private static final long serialVersionUID = 1L;

}
