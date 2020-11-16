package com.fouo.order.mapper;

import com.fouo.order.entity.RefundInfo;
import com.fouo.order.vo.RefundInfoVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 退款信息 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface RefundInfoMapper extends BaseMapper<RefundInfo> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param refundInfo
	 * @return
	 */
	List<RefundInfoVO> selectRefundInfoPage(IPage page, RefundInfoVO refundInfo);

}
