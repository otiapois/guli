package com.fouo.order.dto;

import com.fouo.order.entity.OrderReturnApply;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单退货申请数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderReturnApplyDTO extends OrderReturnApply {
	private static final long serialVersionUID = 1L;

}
