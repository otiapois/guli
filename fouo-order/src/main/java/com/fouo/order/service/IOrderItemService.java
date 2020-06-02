package com.fouo.order.service;

import com.fouo.order.entity.OrderItem;
import com.fouo.order.vo.OrderItemVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 订单项信息 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IOrderItemService extends IService<OrderItem> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param orderItem
	 * @return
	 */
	IPage<OrderItemVO> selectOrderItemPage(IPage<OrderItemVO> page, OrderItemVO orderItem);

}
