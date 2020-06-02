package com.fouo.coupon.mapper;

import com.fouo.coupon.entity.Coupon;
import com.fouo.coupon.vo.CouponVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 优惠券信息 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface CouponMapper extends BaseMapper<Coupon> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param coupon
	 * @return
	 */
	List<CouponVO> selectCouponPage(IPage page, CouponVO coupon);

}
