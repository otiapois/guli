package com.fouo.order.vo;

import com.fouo.order.entity.OrderSetting;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 订单配置信息视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OrderSettingVO对象", description = "订单配置信息")
public class OrderSettingVO extends OrderSetting {
	private static final long serialVersionUID = 1L;

}
