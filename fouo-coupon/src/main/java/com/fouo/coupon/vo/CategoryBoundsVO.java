package com.fouo.coupon.vo;

import com.fouo.coupon.entity.CategoryBounds;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品分类积分设置视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "CategoryBoundsVO对象", description = "商品分类积分设置")
public class CategoryBoundsVO extends CategoryBounds {
	private static final long serialVersionUID = 1L;

}
