package com.fouo.coupon.dto;

import com.fouo.coupon.entity.CouponSpuRelation;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 优惠券与产品关联数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CouponSpuRelationDTO extends CouponSpuRelation {
	private static final long serialVersionUID = 1L;

}
