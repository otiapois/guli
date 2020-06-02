package com.fouo.coupon.mapper;

import com.fouo.coupon.entity.CouponSpuCategoryRelation;
import com.fouo.coupon.vo.CouponSpuCategoryRelationVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 优惠券分类关联 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface CouponSpuCategoryRelationMapper extends BaseMapper<CouponSpuCategoryRelation> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param couponSpuCategoryRelation
	 * @return
	 */
	List<CouponSpuCategoryRelationVO> selectCouponSpuCategoryRelationPage(IPage page, CouponSpuCategoryRelationVO couponSpuCategoryRelation);

}
