package com.fouo.coupon.vo;

import com.fouo.coupon.entity.SpuBounds;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品spu积分设置视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SpuBoundsVO对象", description = "商品spu积分设置")
public class SpuBoundsVO extends SpuBounds {
	private static final long serialVersionUID = 1L;

}
