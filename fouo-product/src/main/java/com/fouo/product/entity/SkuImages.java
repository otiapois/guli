package com.fouo.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * sku图片实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@TableName("pms_sku_images")
@ApiModel(value = "SkuImages对象", description = "sku图片")
public class SkuImages implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
		@ApiModelProperty(value = "id")
		@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* sku_id
	*/
		@ApiModelProperty(value = "sku_id")
		private Long skuId;
	/**
	* 图片地址
	*/
		@ApiModelProperty(value = "图片地址")
		private String imgUrl;
	/**
	* 排序
	*/
		@ApiModelProperty(value = "排序")
		private Integer imgSort;
	/**
	* 默认图[0 - 不是默认图，1 - 是默认图]
	*/
		@ApiModelProperty(value = "默认图[0 - 不是默认图，1 - 是默认图]")
		private Integer defaultImg;


}
