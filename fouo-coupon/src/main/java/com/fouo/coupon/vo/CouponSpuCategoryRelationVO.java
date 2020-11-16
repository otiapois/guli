package com.fouo.coupon.vo;

import com.fouo.coupon.entity.CouponSpuCategoryRelation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 优惠券分类关联视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "CouponSpuCategoryRelationVO对象", description = "优惠券分类关联")
public class CouponSpuCategoryRelationVO extends CouponSpuCategoryRelation {
	private static final long serialVersionUID = 1L;

}
