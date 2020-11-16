package com.fouo.order.service.impl;

import com.fouo.order.entity.OrderReturnReason;
import com.fouo.order.vo.OrderReturnReasonVO;
import com.fouo.order.mapper.OrderReturnReasonMapper;
import com.fouo.order.service.IOrderReturnReasonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 退货原因 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class OrderReturnReasonServiceImpl extends ServiceImpl<OrderReturnReasonMapper, OrderReturnReason> implements IOrderReturnReasonService {

	@Override
	public IPage<OrderReturnReasonVO> selectOrderReturnReasonPage(IPage<OrderReturnReasonVO> page, OrderReturnReasonVO orderReturnReason) {
		return page.setRecords(baseMapper.selectOrderReturnReasonPage(page, orderReturnReason));
	}

}
