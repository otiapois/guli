package com.fouo.order.mapper;

import com.fouo.order.entity.Order;
import com.fouo.order.vo.OrderVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 订单 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface OrderMapper extends BaseMapper<Order> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param order
	 * @return
	 */
	List<OrderVO> selectOrderPage(IPage page, OrderVO order);

}
