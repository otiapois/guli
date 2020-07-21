package com.fouo.product.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import com.fouo.common.valid.AddGroup;
import com.fouo.common.valid.ListValue;
import com.fouo.common.valid.UpdateGroup;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

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
    @Null(message = "新增不能指定id",groups = {AddGroup.class})
    @NotNull(message = "修改必须指定品牌id",groups = {UpdateGroup.class})
    @TableId(value = "brand_id", type = IdType.AUTO)
    private Long brandId;
    /**
     * 品牌名
     */
    @ApiModelProperty(value = "品牌名")
    @NotBlank(message = "品牌名称不能为空",groups = {AddGroup.class,UpdateGroup.class})
    private String name;
    /**
     * 品牌logo地址
     */
    @ApiModelProperty(value = "品牌logo地址")
    @URL(message = "logo必须为一个合法的url地址",groups = {AddGroup.class,UpdateGroup.class})
    @NotBlank(message = "品牌logo地址不能为空",groups = {AddGroup.class})
    private String logo;
    /**
     * 介绍
     */
    @ApiModelProperty(value = "介绍")
    private String descript;
    /**
     * 显示状态[0-不显示；1-显示]
     * 进行逻辑删除
     */
    @ApiModelProperty(value = "显示状态[0-不显示；1-显示]")
    @TableField(value = "show_status")
//    @TableLogic(value = "1", delval = "0")
    @ListValue(vals = {0,1},message = "必须提交指定的值",groups = {AddGroup.class})
    private Integer showStatus;
    /**
     * 检索首字母
     */
    @ApiModelProperty(value = "检索首字母")
    @Pattern(regexp = "/^[a-zA-Z]$",message = "检索首字母必须是一个字母",groups = {AddGroup.class,UpdateGroup.class})
    private String firstLetter;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    @Min(value = 0,message = "排序必须大于等于0",groups = {AddGroup.class,UpdateGroup.class})
    private Integer sort;

    /**
     * 是否已删除
     */
    @ApiModelProperty(value = "是否已删除")
    @TableLogic
    private Integer isDeleted;
}
