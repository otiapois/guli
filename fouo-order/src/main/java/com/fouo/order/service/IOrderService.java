package com.fouo.order.service;

import com.fouo.order.entity.Order;
import com.fouo.order.vo.OrderVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 订单 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IOrderService extends IService<Order> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param order
	 * @return
	 */
	IPage<OrderVO> selectOrderPage(IPage<OrderVO> page, OrderVO order);

}
