package com.fouo.order.mapper;

import com.fouo.order.entity.OrderItem;
import com.fouo.order.vo.OrderItemVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 订单项信息 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface OrderItemMapper extends BaseMapper<OrderItem> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param orderItem
	 * @return
	 */
	List<OrderItemVO> selectOrderItemPage(IPage page, OrderItemVO orderItem);

}
