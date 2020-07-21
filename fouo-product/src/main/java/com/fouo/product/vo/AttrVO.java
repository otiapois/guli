package com.fouo.product.vo;

import com.fouo.product.entity.Attr;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品属性视图实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "AttrVO对象", description = "商品属性")
public class AttrVO extends Attr {
    private static final long serialVersionUID = 1L;

    /**
     * 分组id
     */
    @ApiModelProperty(value = "分组id")
    private Long attrGroupId;

    /**
     * 关键字
     */
    @ApiModelProperty(value = "关键字")
    private String searchKeyword;

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称")
    private String catelogName;

    /**
     * 分组名称
     */
    @ApiModelProperty(value = "分组名称")
    private String groupName;

    /**
     * 三级分类数组
     */
    @ApiModelProperty(value="三级分类")
    private Long[] catelogPath;

}
