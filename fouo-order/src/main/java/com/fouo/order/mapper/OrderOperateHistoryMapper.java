package com.fouo.order.mapper;

import com.fouo.order.entity.OrderOperateHistory;
import com.fouo.order.vo.OrderOperateHistoryVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 订单操作历史记录 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface OrderOperateHistoryMapper extends BaseMapper<OrderOperateHistory> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param orderOperateHistory
	 * @return
	 */
	List<OrderOperateHistoryVO> selectOrderOperateHistoryPage(IPage page, OrderOperateHistoryVO orderOperateHistory);

}
