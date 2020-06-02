package com.fouo.order.service.impl;

import com.fouo.order.entity.OrderItem;
import com.fouo.order.vo.OrderItemVO;
import com.fouo.order.mapper.OrderItemMapper;
import com.fouo.order.service.IOrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 订单项信息 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements IOrderItemService {

	@Override
	public IPage<OrderItemVO> selectOrderItemPage(IPage<OrderItemVO> page, OrderItemVO orderItem) {
		return page.setRecords(baseMapper.selectOrderItemPage(page, orderItem));
	}

}
