package com.fouo.coupon.service;

import com.fouo.coupon.entity.Coupon;
import com.fouo.coupon.vo.CouponVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 优惠券信息 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface ICouponService extends IService<Coupon> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param coupon
	 * @return
	 */
	IPage<CouponVO> selectCouponPage(IPage<CouponVO> page, CouponVO coupon);

}
