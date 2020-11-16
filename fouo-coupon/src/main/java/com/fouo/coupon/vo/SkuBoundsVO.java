package com.fouo.coupon.vo;

import com.fouo.coupon.entity.SkuBounds;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品sku积分设置视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SkuBoundsVO对象", description = "商品sku积分设置")
public class SkuBoundsVO extends SkuBounds {
	private static final long serialVersionUID = 1L;

}
