package com.fouo.order.service.impl;

import com.fouo.order.entity.OrderReturnApply;
import com.fouo.order.vo.OrderReturnApplyVO;
import com.fouo.order.mapper.OrderReturnApplyMapper;
import com.fouo.order.service.IOrderReturnApplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 订单退货申请 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class OrderReturnApplyServiceImpl extends ServiceImpl<OrderReturnApplyMapper, OrderReturnApply> implements IOrderReturnApplyService {

	@Override
	public IPage<OrderReturnApplyVO> selectOrderReturnApplyPage(IPage<OrderReturnApplyVO> page, OrderReturnApplyVO orderReturnApply) {
		return page.setRecords(baseMapper.selectOrderReturnApplyPage(page, orderReturnApply));
	}

}
