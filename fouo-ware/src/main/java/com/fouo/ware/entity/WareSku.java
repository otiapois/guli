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
 * 商品库存实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("wms_ware_sku")
@ApiModel(value = "WareSku对象", description = "商品库存")
public class WareSku implements Serializable {

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
     * 仓库id
     */
    @ApiModelProperty(value = "仓库id")
    private Long wareId;
    /**
     * 库存数
     */
    @ApiModelProperty(value = "库存数")
    private Integer stock;
    /**
     * sku_name
     */
    @ApiModelProperty(value = "sku_name")
    private String skuName;
    /**
     * 锁定库存
     */
    @ApiModelProperty(value = "锁定库存")
    private Integer stockLocked;
    /**
     * 是否已删除
     */
    @ApiModelProperty(value = "是否已删除")
    @TableLogic
    private Integer isDeleted;

}
