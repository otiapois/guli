package com.fouo.coupon.service;

import com.fouo.coupon.entity.CouponSpuCategoryRelation;
import com.fouo.coupon.vo.CouponSpuCategoryRelationVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 优惠券分类关联 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface ICouponSpuCategoryRelationService extends IService<CouponSpuCategoryRelation> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param couponSpuCategoryRelation
	 * @return
	 */
	IPage<CouponSpuCategoryRelationVO> selectCouponSpuCategoryRelationPage(IPage<CouponSpuCategoryRelationVO> page, CouponSpuCategoryRelationVO couponSpuCategoryRelation);

}
