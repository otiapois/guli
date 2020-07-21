package com.fouo.ware.entity;

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
 * 仓库信息实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("wms_ware_info")
@ApiModel(value = "WareInfo对象", description = "仓库信息")
public class WareInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 仓库名
     */
    @ApiModelProperty(value = "仓库名")
    private String name;
    /**
     * 仓库地址
     */
    @ApiModelProperty(value = "仓库地址")
    private String address;
    /**
     * 区域编码
     */
    @ApiModelProperty(value = "区域编码")
    private String areacode;

    /**
     * 是否已删除
     */
    @ApiModelProperty(value = "是否已删除")
    @TableLogic
    private Integer isDeleted;

}
