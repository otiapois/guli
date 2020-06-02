package com.fouo.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 秒杀商品通知订阅实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("sms_seckill_sku_notice")
@ApiModel(value = "SeckillSkuNotice对象", description = "秒杀商品通知订阅")
public class SeckillSkuNotice implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
		@ApiModelProperty(value = "id")
		@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* member_id
	*/
		@ApiModelProperty(value = "member_id")
		private Long memberId;
	/**
	* sku_id
	*/
		@ApiModelProperty(value = "sku_id")
		private Long skuId;
	/**
	* 活动场次id
	*/
		@ApiModelProperty(value = "活动场次id")
		private Long sessionId;
	/**
	* 订阅时间
	*/
		@ApiModelProperty(value = "订阅时间")
		private LocalDateTime subcribeTime;
	/**
	* 发送时间
	*/
		@ApiModelProperty(value = "发送时间")
		private LocalDateTime sendTime;
	/**
	* 通知方式[0-短信，1-邮件]
	*/
		@ApiModelProperty(value = "通知方式[0-短信，1-邮件]")
		private Boolean noticeType;


}
