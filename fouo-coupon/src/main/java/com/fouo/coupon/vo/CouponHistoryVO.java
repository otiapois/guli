package com.fouo.coupon.vo;

import com.fouo.coupon.entity.CouponHistory;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 优惠券领取历史记录视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "CouponHistoryVO对象", description = "优惠券领取历史记录")
public class CouponHistoryVO extends CouponHistory {
	private static final long serialVersionUID = 1L;

}
