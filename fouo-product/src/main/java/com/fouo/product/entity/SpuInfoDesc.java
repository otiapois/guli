package com.fouo.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * spu信息介绍实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@TableName("pms_spu_info_desc")
@ApiModel(value = "SpuInfoDesc对象", description = "spu信息介绍")
public class SpuInfoDesc implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* 商品id
	*/
		@ApiModelProperty(value = "商品id")
		private Long spuId;
	/**
	* 商品介绍
	*/
		@ApiModelProperty(value = "商品介绍")
		private String decript;


}
