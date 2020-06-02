package com.fouo.coupon.vo;

import com.fouo.coupon.entity.SeckillSkuNotice;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 秒杀商品通知订阅视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SeckillSkuNoticeVO对象", description = "秒杀商品通知订阅")
public class SeckillSkuNoticeVO extends SeckillSkuNotice {
	private static final long serialVersionUID = 1L;

}
