package com.fouo.product.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 属性&属性分组关联实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@TableName("pms_attr_attrgroup_relation")
@ApiModel(value = "AttrAttrgroupRelation对象", description = "属性&属性分组关联")
public class AttrAttrgroupRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 属性id
     */
    @ApiModelProperty(value = "属性id")
    private Long attrId;
    /**
     * 属性分组id
     */
    @ApiModelProperty(value = "属性分组id")
    private Long attrGroupId;
    /**
     * 属性组内排序
     */
    @ApiModelProperty(value = "属性组内排序")
    private Integer attrSort;

    /**
     * 是否已删除
     */
    @ApiModelProperty(value = "是否已删除")
    @TableLogic
    private Integer isDeleted;


}
