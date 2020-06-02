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
 * 品牌实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@TableName("pms_brand")
@ApiModel(value = "Brand对象", description = "品牌")
public class Brand implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* 品牌id
	*/
		@ApiModelProperty(value = "品牌id")
		@TableId(value = "brand_id", type = IdType.AUTO)
	private Long brandId;
	/**
	* 品牌名
	*/
		@ApiModelProperty(value = "品牌名")
		private String name;
	/**
	* 品牌logo地址
	*/
		@ApiModelProperty(value = "品牌logo地址")
		private String logo;
	/**
	* 介绍
	*/
		@ApiModelProperty(value = "介绍")
		private String descript;
	/**
	* 显示状态[0-不显示；1-显示]
	*/
		@ApiModelProperty(value = "显示状态[0-不显示；1-显示]")
		private Integer showStatus;
	/**
	* 检索首字母
	*/
		@ApiModelProperty(value = "检索首字母")
		private String firstLetter;
	/**
	* 排序
	*/
		@ApiModelProperty(value = "排序")
		private Integer sort;


}
