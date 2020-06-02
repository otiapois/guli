package com.fouo.coupon.dto;

import com.fouo.coupon.entity.CategoryBounds;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品分类积分设置数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryBoundsDTO extends CategoryBounds {
	private static final long serialVersionUID = 1L;

}
