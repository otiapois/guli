package com.fouo.product.dto;

import com.fouo.product.entity.SkuImages;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * sku图片数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SkuImagesDTO extends SkuImages {
	private static final long serialVersionUID = 1L;

}
