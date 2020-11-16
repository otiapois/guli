package com.fouo.product.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

/**
 * 商品属性实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("pms_attr")
@ApiModel(value = "Attr对象", description = "商品属性")
public class Attr implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 属性id
     */
    @ApiModelProperty(value = "属性id")
    @TableId(value = "attr_id", type = IdType.AUTO)
    private Long attrId;
    /**
     * 属性名
     */
    @ApiModelProperty(value = "属性名")
    private String attrName;
    /**
     * 是否需要检索[0-不需要，1-需要]
     */
    @ApiModelProperty(value = "是否需要检索[0-不需要，1-需要]")
    private Integer searchType;
    /**
     * 属性图标
     */
    @ApiModelProperty(value = "属性图标")
    private String icon;
    /**
     * 可选值列表[用逗号分隔]
     */
    @ApiModelProperty(value = "可选值列表[用逗号分隔]")
    private String valueSelect;
    /**
     * 属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]
     */
    @ApiModelProperty(value = "属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]")
    private Integer attrType;
    /**
     * 启用状态[0 - 禁用，1 - 启用]
     */
    @ApiModelProperty(value = "值类型[0 - 只能单个值，1 - 允许多个值]")
    private Integer valueType;
    /**
     * 启用状态[0 - 禁用，1 - 启用]
     */
    @ApiModelProperty(value = "启用状态[0 - 禁用，1 - 启用]")
    private Long enable;
    /**
     * 所属分类
     */
    @ApiModelProperty(value = "所属分类")
    private Long catelogId;
    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
     */
    @ApiModelProperty(value = "快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整")
    private Integer showDesc;

	/**
	 * 是否已删除
	 */
	@ApiModelProperty(value = "是否已删除")
	@TableLogic
	private Integer isDeleted;

}
