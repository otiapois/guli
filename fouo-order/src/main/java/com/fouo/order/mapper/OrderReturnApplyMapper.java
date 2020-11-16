package com.fouo.order.mapper;

import com.fouo.order.entity.OrderReturnApply;
import com.fouo.order.vo.OrderReturnApplyVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 订单退货申请 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface OrderReturnApplyMapper extends BaseMapper<OrderReturnApply> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param orderReturnApply
	 * @return
	 */
	List<OrderReturnApplyVO> selectOrderReturnApplyPage(IPage page, OrderReturnApplyVO orderReturnApply);

}
