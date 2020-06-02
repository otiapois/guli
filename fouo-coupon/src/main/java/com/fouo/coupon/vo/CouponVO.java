package com.fouo.coupon.vo;

import com.fouo.coupon.entity.Coupon;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 优惠券信息视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "CouponVO对象", description = "优惠券信息")
public class CouponVO extends Coupon {
	private static final long serialVersionUID = 1L;

}
