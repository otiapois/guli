package com.fouo.coupon.dto;

import com.fouo.coupon.entity.SeckillPromotion;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 秒杀活动数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SeckillPromotionDTO extends SeckillPromotion {
	private static final long serialVersionUID = 1L;

}
