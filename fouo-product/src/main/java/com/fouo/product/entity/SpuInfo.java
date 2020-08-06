package com.fouo.product.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * spu信息实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@TableName("pms_spu_info")
@ApiModel(value = "SpuInfo对象", description = "spu信息")
public class SpuInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String spuName;
    /**
     * 商品描述
     */
    @ApiModelProperty(value = "商品描述")
    private String spuDescription;
    /**
     * 所属分类id
     */
    @ApiModelProperty(value = "所属分类id")
    private Long catalogId;
    /**
     * 品牌id
     */
    @ApiModelProperty(value = "品牌id")
    private Long brandId;
    private BigDecimal weight;
    /**
     * 上架状态[0 - 下架，1 - 上架]
     */
    @ApiModelProperty(value = "上架状态[0 - 下架，1 - 上架]")
    private Integer publishStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    /**
     * 是否已删除
     */
    @ApiModelProperty(value = "是否已删除")
    @TableLogic
    private Integer isDeleted;
}
