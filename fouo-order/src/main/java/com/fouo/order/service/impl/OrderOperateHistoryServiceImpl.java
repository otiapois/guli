package com.fouo.order.service.impl;

import com.fouo.order.entity.OrderOperateHistory;
import com.fouo.order.vo.OrderOperateHistoryVO;
import com.fouo.order.mapper.OrderOperateHistoryMapper;
import com.fouo.order.service.IOrderOperateHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 订单操作历史记录 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class OrderOperateHistoryServiceImpl extends ServiceImpl<OrderOperateHistoryMapper, OrderOperateHistory> implements IOrderOperateHistoryService {

	@Override
	public IPage<OrderOperateHistoryVO> selectOrderOperateHistoryPage(IPage<OrderOperateHistoryVO> page, OrderOperateHistoryVO orderOperateHistory) {
		return page.setRecords(baseMapper.selectOrderOperateHistoryPage(page, orderOperateHistory));
	}

}
