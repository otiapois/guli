package com.fouo.coupon.mapper;

import com.fouo.coupon.entity.CouponHistory;
import com.fouo.coupon.vo.CouponHistoryVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 优惠券领取历史记录 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface CouponHistoryMapper extends BaseMapper<CouponHistory> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param couponHistory
	 * @return
	 */
	List<CouponHistoryVO> selectCouponHistoryPage(IPage page, CouponHistoryVO couponHistory);

}
