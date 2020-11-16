package com.fouo.order.service;

import com.fouo.order.entity.OrderSetting;
import com.fouo.order.vo.OrderSettingVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 订单配置信息 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IOrderSettingService extends IService<OrderSetting> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param orderSetting
	 * @return
	 */
	IPage<OrderSettingVO> selectOrderSettingPage(IPage<OrderSettingVO> page, OrderSettingVO orderSetting);

}
