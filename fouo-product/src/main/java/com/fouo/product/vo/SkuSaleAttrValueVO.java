package com.fouo.product.vo;

import com.fouo.product.entity.SkuSaleAttrValue;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * sku销售属性&值视图实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SkuSaleAttrValueVO对象", description = "sku销售属性&值")
public class SkuSaleAttrValueVO extends SkuSaleAttrValue {
	private static final long serialVersionUID = 1L;

}
