package com.fouo.coupon.dto;

import com.fouo.coupon.entity.SeckillSkuNotice;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 秒杀商品通知订阅数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SeckillSkuNoticeDTO extends SeckillSkuNotice {
	private static final long serialVersionUID = 1L;

}
