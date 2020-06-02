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
 * 商品三级分类实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@TableName("pms_category")
@ApiModel(value = "Category对象", description = "商品三级分类")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* 分类id
	*/
		@ApiModelProperty(value = "分类id")
		@TableId(value = "cat_id", type = IdType.AUTO)
	private Long catId;
	/**
	* 分类名称
	*/
		@ApiModelProperty(value = "分类名称")
		private String name;
	/**
	* 父分类id
	*/
		@ApiModelProperty(value = "父分类id")
		private Long parentCid;
	/**
	* 层级
	*/
		@ApiModelProperty(value = "层级")
		private Integer catLevel;
	/**
	* 是否显示[0-不显示，1显示]
	*/
		@ApiModelProperty(value = "是否显示[0-不显示，1显示]")
		private Integer showStatus;
	/**
	* 排序
	*/
		@ApiModelProperty(value = "排序")
		private Integer sort;
	/**
	* 图标地址
	*/
		@ApiModelProperty(value = "图标地址")
		private String icon;
	/**
	* 计量单位
	*/
		@ApiModelProperty(value = "计量单位")
		private String productUnit;
	/**
	* 商品数量
	*/
		@ApiModelProperty(value = "商品数量")
		private Integer productCount;


}
