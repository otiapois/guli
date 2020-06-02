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
 * 优惠券领取历史记录实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("sms_coupon_history")
@ApiModel(value = "CouponHistory对象", description = "优惠券领取历史记录")
public class CouponHistory implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
		@ApiModelProperty(value = "id")
		@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* 优惠券id
	*/
		@ApiModelProperty(value = "优惠券id")
		private Long couponId;
	/**
	* 会员id
	*/
		@ApiModelProperty(value = "会员id")
		private Long memberId;
	/**
	* 会员名字
	*/
		@ApiModelProperty(value = "会员名字")
		private String memberNickName;
	/**
	* 获取方式[0->后台赠送；1->主动领取]
	*/
		@ApiModelProperty(value = "获取方式[0->后台赠送；1->主动领取]")
		private Boolean getType;
	/**
	* 创建时间
	*/
		@ApiModelProperty(value = "创建时间")
		private LocalDateTime createTime;
	/**
	* 使用状态[0->未使用；1->已使用；2->已过期]
	*/
		@ApiModelProperty(value = "使用状态[0->未使用；1->已使用；2->已过期]")
		private Boolean useType;
	/**
	* 使用时间
	*/
		@ApiModelProperty(value = "使用时间")
		private LocalDateTime useTime;
	/**
	* 订单id
	*/
		@ApiModelProperty(value = "订单id")
		private Long orderId;
	/**
	* 订单号
	*/
		@ApiModelProperty(value = "订单号")
		private Long orderSn;


}
