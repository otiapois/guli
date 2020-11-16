package com.fouo.order.dto;

import com.fouo.order.entity.OrderSetting;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单配置信息数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderSettingDTO extends OrderSetting {
	private static final long serialVersionUID = 1L;

}
