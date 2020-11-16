/**
  * Copyright 2019 bejson.com 
  */
package com.fouo.product.vo.ext;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Auto-generated: 2019-11-26 10:50:34
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class Bounds {
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