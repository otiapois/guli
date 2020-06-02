package com.fouo.product.dto;

import com.fouo.product.entity.Brand;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 品牌数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BrandDTO extends Brand {
	private static final long serialVersionUID = 1L;

}
