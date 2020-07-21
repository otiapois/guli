package com.fouo.product.vo;

import com.fouo.product.entity.SkuInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

import java.math.BigDecimal;

/**
 * sku信息视图实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SkuInfoVO对象", description = "sku信息")
public class SkuInfoVO extends SkuInfo {
	private static final long serialVersionUID = 1L;

	/**
	 * 关键字
	 */
	@ApiModelProperty(value = "关键字")
	private String searchKeyword;
	/**
	 * 价格最小值
	 */
	@ApiModelProperty(value = "min")
	private BigDecimal min;
	/**
	 * 价格最大值
	 */
	@ApiModelProperty(value = "max")
	private BigDecimal max;
}
