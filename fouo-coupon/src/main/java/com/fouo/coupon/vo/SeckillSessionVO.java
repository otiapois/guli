package com.fouo.coupon.vo;

import com.fouo.coupon.entity.SeckillSession;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 秒杀活动场次视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SeckillSessionVO对象", description = "秒杀活动场次")
public class SeckillSessionVO extends SeckillSession {
	private static final long serialVersionUID = 1L;

}
