package com.fouo.product.vo;

import com.fouo.product.entity.Category;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品三级分类视图实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "CategoryVO对象", description = "商品三级分类")
public class CategoryVO extends Category {
	private static final long serialVersionUID = 1L;

}
