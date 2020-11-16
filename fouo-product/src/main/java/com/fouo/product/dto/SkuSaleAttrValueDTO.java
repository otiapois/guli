package com.fouo.product.dto;

import com.fouo.product.entity.SkuSaleAttrValue;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * sku销售属性&值数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SkuSaleAttrValueDTO extends SkuSaleAttrValue {
	private static final long serialVersionUID = 1L;

}
