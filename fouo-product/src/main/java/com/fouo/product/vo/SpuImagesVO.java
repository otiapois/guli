package com.fouo.product.vo;

import com.fouo.product.entity.SpuImages;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * spu图片视图实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SpuImagesVO对象", description = "spu图片")
public class SpuImagesVO extends SpuImages {
	private static final long serialVersionUID = 1L;

}
