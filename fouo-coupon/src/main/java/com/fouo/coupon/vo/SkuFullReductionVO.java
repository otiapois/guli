package com.fouo.coupon.vo;

import com.fouo.coupon.entity.SkuFullReduction;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品满减信息视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SkuFullReductionVO对象", description = "商品满减信息")
public class SkuFullReductionVO extends SkuFullReduction {
	private static final long serialVersionUID = 1L;

}
