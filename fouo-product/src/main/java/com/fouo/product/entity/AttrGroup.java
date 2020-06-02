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
 * 属性分组实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@TableName("pms_attr_group")
@ApiModel(value = "AttrGroup对象", description = "属性分组")
public class AttrGroup implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* 分组id
	*/
		@ApiModelProperty(value = "分组id")
		@TableId(value = "attr_group_id", type = IdType.AUTO)
	private Long attrGroupId;
	/**
	* 组名
	*/
		@ApiModelProperty(value = "组名")
		private String attrGroupName;
	/**
	* 排序
	*/
		@ApiModelProperty(value = "排序")
		private Integer sort;
	/**
	* 描述
	*/
		@ApiModelProperty(value = "描述")
		private String descript;
	/**
	* 组图标
	*/
		@ApiModelProperty(value = "组图标")
		private String icon;
	/**
	* 所属分类id
	*/
		@ApiModelProperty(value = "所属分类id")
		private Long catelogId;


}
