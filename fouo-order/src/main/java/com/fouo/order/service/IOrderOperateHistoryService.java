package com.fouo.order.service;

import com.fouo.order.entity.OrderOperateHistory;
import com.fouo.order.vo.OrderOperateHistoryVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 订单操作历史记录 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IOrderOperateHistoryService extends IService<OrderOperateHistory> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param orderOperateHistory
	 * @return
	 */
	IPage<OrderOperateHistoryVO> selectOrderOperateHistoryPage(IPage<OrderOperateHistoryVO> page, OrderOperateHistoryVO orderOperateHistory);

}
