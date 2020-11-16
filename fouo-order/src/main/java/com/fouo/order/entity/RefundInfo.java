package com.fouo.order.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 退款信息实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("oms_refund_info")
@ApiModel(value = "RefundInfo对象", description = "退款信息")
public class RefundInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
		@ApiModelProperty(value = "id")
		@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* 退款的订单
	*/
		@ApiModelProperty(value = "退款的订单")
		private Long orderReturnId;
	/**
	* 退款金额
	*/
		@ApiModelProperty(value = "退款金额")
		private BigDecimal refund;
	/**
	* 退款交易流水号
	*/
		@ApiModelProperty(value = "退款交易流水号")
		private String refundSn;
	/**
	* 退款状态
	*/
		@ApiModelProperty(value = "退款状态")
		private Boolean refundStatus;
	/**
	* 退款渠道[1-支付宝，2-微信，3-银联，4-汇款]
	*/
		@ApiModelProperty(value = "退款渠道[1-支付宝，2-微信，3-银联，4-汇款]")
		private Integer refundChannel;
	private String refundContent;


}
