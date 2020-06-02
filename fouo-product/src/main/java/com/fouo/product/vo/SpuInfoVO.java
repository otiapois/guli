package com.fouo.product.vo;

import com.fouo.product.entity.SpuInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * spu信息视图实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SpuInfoVO对象", description = "spu信息")
public class SpuInfoVO extends SpuInfo {
	private static final long serialVersionUID = 1L;

}
