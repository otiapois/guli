package com.fouo.product.dto;

import com.fouo.product.entity.Category;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品三级分类数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryDTO extends Category {
	private static final long serialVersionUID = 1L;

}
