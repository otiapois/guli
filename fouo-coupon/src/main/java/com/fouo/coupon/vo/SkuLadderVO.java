package com.fouo.coupon.vo;

import com.fouo.coupon.entity.SkuLadder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品阶梯价格视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SkuLadderVO对象", description = "商品阶梯价格")
public class SkuLadderVO extends SkuLadder {
	private static final long serialVersionUID = 1L;

}
