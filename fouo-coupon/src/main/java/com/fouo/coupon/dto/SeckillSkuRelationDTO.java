package com.fouo.coupon.dto;

import com.fouo.coupon.entity.SeckillSkuRelation;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 秒杀活动商品关联数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SeckillSkuRelationDTO extends SeckillSkuRelation {
	private static final long serialVersionUID = 1L;

}
