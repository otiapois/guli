package com.fouo.coupon.dto;

import com.fouo.coupon.entity.HomeAdv;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 首页轮播广告数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class HomeAdvDTO extends HomeAdv {
	private static final long serialVersionUID = 1L;

}
