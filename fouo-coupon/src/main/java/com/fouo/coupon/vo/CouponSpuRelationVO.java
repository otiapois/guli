package com.fouo.coupon.vo;

import com.fouo.coupon.entity.CouponSpuRelation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 优惠券与产品关联视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "CouponSpuRelationVO对象", description = "优惠券与产品关联")
public class CouponSpuRelationVO extends CouponSpuRelation {
	private static final long serialVersionUID = 1L;

}
