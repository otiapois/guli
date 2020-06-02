package com.fouo.coupon.vo;

import com.fouo.coupon.entity.MemberPrice;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品会员价格视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "MemberPriceVO对象", description = "商品会员价格")
public class MemberPriceVO extends MemberPrice {
	private static final long serialVersionUID = 1L;

}
