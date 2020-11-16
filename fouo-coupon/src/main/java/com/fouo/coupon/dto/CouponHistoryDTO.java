package com.fouo.coupon.dto;

import com.fouo.coupon.entity.CouponHistory;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 优惠券领取历史记录数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CouponHistoryDTO extends CouponHistory {
	private static final long serialVersionUID = 1L;

}
