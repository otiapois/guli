package com.fouo.order.service;

import com.fouo.order.entity.OrderReturnApply;
import com.fouo.order.vo.OrderReturnApplyVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 订单退货申请 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IOrderReturnApplyService extends IService<OrderReturnApply> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param orderReturnApply
	 * @return
	 */
	IPage<OrderReturnApplyVO> selectOrderReturnApplyPage(IPage<OrderReturnApplyVO> page, OrderReturnApplyVO orderReturnApply);

}
