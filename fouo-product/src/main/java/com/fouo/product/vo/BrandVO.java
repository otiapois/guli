package com.fouo.product.vo;

import com.fouo.product.entity.Brand;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 品牌视图实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "BrandVO对象", description = "品牌")
public class BrandVO extends Brand {
	private static final long serialVersionUID = 1L;
	/**
	 * 关键字
	 */
	@ApiModelProperty(value = "关键字")
	private String searchKeyword;
}
