package com.fouo.product.dto;

import com.fouo.product.entity.ProductAttrValue;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * spu属性值数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductAttrValueDTO extends ProductAttrValue {
	private static final long serialVersionUID = 1L;

}
