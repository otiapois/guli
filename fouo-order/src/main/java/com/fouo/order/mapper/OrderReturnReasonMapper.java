package com.fouo.order.mapper;

import com.fouo.order.entity.OrderReturnReason;
import com.fouo.order.vo.OrderReturnReasonVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 退货原因 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface OrderReturnReasonMapper extends BaseMapper<OrderReturnReason> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param orderReturnReason
	 * @return
	 */
	List<OrderReturnReasonVO> selectOrderReturnReasonPage(IPage page, OrderReturnReasonVO orderReturnReason);

}
