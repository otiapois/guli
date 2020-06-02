package com.fouo.order.service;

import com.fouo.order.entity.OrderReturnReason;
import com.fouo.order.vo.OrderReturnReasonVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 退货原因 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IOrderReturnReasonService extends IService<OrderReturnReason> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param orderReturnReason
	 * @return
	 */
	IPage<OrderReturnReasonVO> selectOrderReturnReasonPage(IPage<OrderReturnReasonVO> page, OrderReturnReasonVO orderReturnReason);

}
