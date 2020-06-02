package com.fouo.coupon.dto;

import com.fouo.coupon.entity.CouponSpuCategoryRelation;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 优惠券分类关联数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CouponSpuCategoryRelationDTO extends CouponSpuCategoryRelation {
	private static final long serialVersionUID = 1L;

}
