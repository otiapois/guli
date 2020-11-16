package com.fouo.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 品牌&分类分组关联实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@TableName("pms_category_brand_relation")
@ApiModel(value = "CategoryBrandRelation对象", description = "品牌&分类关联")
public class CategoryBrandRelation implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@ApiModelProperty(value = "id")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	 * 品牌id
	 */
	@ApiModelProperty(value = "品牌id")
	private Long brandId;

	/**
	 * 品牌名称
	 */
	@ApiModelProperty(value = "品牌名称")
	private String brandName;
	/**
	 * 分类id
	 */
	@ApiModelProperty(value = "属性分组id")
	private Long catelogId;
	/**
	 * 分类名称
	 */
	@ApiModelProperty(value = "分类名称")
	private String catelogName;
	/**
	 * 是否已删除
	 */
	@ApiModelProperty(value = "是否已删除")
	@TableLogic
	private Integer isDeleted;

}
