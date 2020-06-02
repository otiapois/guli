package com.fouo.product.dto;

import com.fouo.product.entity.SpuImages;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * spu图片数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SpuImagesDTO extends SpuImages {
	private static final long serialVersionUID = 1L;

}
