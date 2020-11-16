package com.fouo.product.vo;

import com.fouo.product.entity.SkuImages;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * sku图片视图实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SkuImagesVO对象", description = "sku图片")
public class SkuImagesVO extends SkuImages {
	private static final long serialVersionUID = 1L;

}
