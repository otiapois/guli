package com.fouo.coupon.vo;

import com.fouo.coupon.entity.SeckillSkuRelation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 秒杀活动商品关联视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SeckillSkuRelationVO对象", description = "秒杀活动商品关联")
public class SeckillSkuRelationVO extends SeckillSkuRelation {
	private static final long serialVersionUID = 1L;

}
