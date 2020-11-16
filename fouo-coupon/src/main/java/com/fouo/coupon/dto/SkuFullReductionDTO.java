package com.fouo.coupon.dto;

import com.fouo.coupon.entity.SkuFullReduction;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品满减信息数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SkuFullReductionDTO extends SkuFullReduction {
	private static final long serialVersionUID = 1L;

}
