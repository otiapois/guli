package com.fouo.order.entity;

import java.math.BigDecimal;
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
 * 支付信息表实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("oms_payment_info")
@ApiModel(value = "PaymentInfo对象", description = "支付信息表")
public class PaymentInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
		@ApiModelProperty(value = "id")
		@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* 订单号（对外业务号）
	*/
		@ApiModelProperty(value = "订单号（对外业务号）")
		private String orderSn;
	/**
	* 订单id
	*/
		@ApiModelProperty(value = "订单id")
		private Long orderId;
	/**
	* 支付宝交易流水号
	*/
		@ApiModelProperty(value = "支付宝交易流水号")
		private String alipayTradeNo;
	/**
	* 支付总金额
	*/
		@ApiModelProperty(value = "支付总金额")
		private BigDecimal totalAmount;
	/**
	* 交易内容
	*/
		@ApiModelProperty(value = "交易内容")
		private String subject;
	/**
	* 支付状态
	*/
		@ApiModelProperty(value = "支付状态")
		private String paymentStatus;
	/**
	* 创建时间
	*/
		@ApiModelProperty(value = "创建时间")
		private LocalDateTime createTime;
	/**
	* 确认时间
	*/
		@ApiModelProperty(value = "确认时间")
		private LocalDateTime confirmTime;
	/**
	* 回调内容
	*/
		@ApiModelProperty(value = "回调内容")
		private String callbackContent;
	/**
	* 回调时间
	*/
		@ApiModelProperty(value = "回调时间")
		private LocalDateTime callbackTime;


}
