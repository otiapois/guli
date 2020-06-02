package com.fouo.product.vo;

import com.fouo.product.entity.SkuInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

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

}
