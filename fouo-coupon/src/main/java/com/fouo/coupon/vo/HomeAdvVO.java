package com.fouo.coupon.vo;

import com.fouo.coupon.entity.HomeAdv;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 首页轮播广告视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "HomeAdvVO对象", description = "首页轮播广告")
public class HomeAdvVO extends HomeAdv {
	private static final long serialVersionUID = 1L;

}
