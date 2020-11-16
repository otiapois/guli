package com.fouo.common.to;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品spu积分设置实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@ApiModel(value = "SpuBounds对象", description = "商品spu积分设置")
public class SpuBoundsTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long id;
    private Long spuId;
    /**
     * 成长积分
     */
    @ApiModelProperty(value = "成长积分")
    private BigDecimal growBounds;
    /**
     * 购物积分
     */
    @ApiModelProperty(value = "购物积分")
    private BigDecimal buyBounds;
    /**
     * 优惠生效情况[1111（四个状态位，从右到左）;0 - 无优惠，成长积分是否赠送;1 - 无优惠，购物积分是否赠送;2 - 有优惠，成长积分是否赠送;3 - 有优惠，购物积分是否赠送【状态位0：不赠送，1：赠送】]
     */
    @ApiModelProperty(value = "优惠生效情况[1111（四个状态位，从右到左）;0 - 无优惠，成长积分是否赠送;1 - 无优惠，购物积分是否赠送;2 - 有优惠，成长积分是否赠送;3 - 有优惠，购物积分是否赠送【状态位0：不赠送，1：赠送】]")
    private Boolean work;


}
