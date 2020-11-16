package com.fouo.coupon.dto;

import com.fouo.coupon.entity.Coupon;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 优惠券信息数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CouponDTO extends Coupon {
	private static final long serialVersionUID = 1L;

}
