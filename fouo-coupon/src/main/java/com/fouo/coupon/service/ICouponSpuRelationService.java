package com.fouo.coupon.service;

import com.fouo.coupon.entity.CouponSpuRelation;
import com.fouo.coupon.vo.CouponSpuRelationVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 优惠券与产品关联 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface ICouponSpuRelationService extends IService<CouponSpuRelation> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param couponSpuRelation
	 * @return
	 */
	IPage<CouponSpuRelationVO> selectCouponSpuRelationPage(IPage<CouponSpuRelationVO> page, CouponSpuRelationVO couponSpuRelation);

}
