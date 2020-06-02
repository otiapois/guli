package com.fouo.order.service.impl;

import com.fouo.order.entity.Order;
import com.fouo.order.vo.OrderVO;
import com.fouo.order.mapper.OrderMapper;
import com.fouo.order.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 订单 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

	@Override
	public IPage<OrderVO> selectOrderPage(IPage<OrderVO> page, OrderVO order) {
		return page.setRecords(baseMapper.selectOrderPage(page, order));
	}

}
