package com.fouo.coupon.dto;

import com.fouo.coupon.entity.SeckillSession;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 秒杀活动场次数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SeckillSessionDTO extends SeckillSession {
	private static final long serialVersionUID = 1L;

}
