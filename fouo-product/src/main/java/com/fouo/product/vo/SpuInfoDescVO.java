package com.fouo.product.vo;

import com.fouo.product.entity.SpuInfoDesc;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * spu信息介绍视图实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SpuInfoDescVO对象", description = "spu信息介绍")
public class SpuInfoDescVO extends SpuInfoDesc {
	private static final long serialVersionUID = 1L;

}
