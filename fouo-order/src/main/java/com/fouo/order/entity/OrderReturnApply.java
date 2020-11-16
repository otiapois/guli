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
 * 订单退货申请实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("oms_order_return_apply")
@ApiModel(value = "OrderReturnApply对象", description = "订单退货申请")
public class OrderReturnApply implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
		@ApiModelProperty(value = "id")
		@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* order_id
	*/
		@ApiModelProperty(value = "order_id")
		private Long orderId;
	/**
	* 退货商品id
	*/
		@ApiModelProperty(value = "退货商品id")
		private Long skuId;
	/**
	* 订单编号
	*/
		@ApiModelProperty(value = "订单编号")
		private String orderSn;
	/**
	* 申请时间
	*/
		@ApiModelProperty(value = "申请时间")
		private LocalDateTime createTime;
	/**
	* 会员用户名
	*/
		@ApiModelProperty(value = "会员用户名")
		private String memberUsername;
	/**
	* 退款金额
	*/
		@ApiModelProperty(value = "退款金额")
		private BigDecimal returnAmount;
	/**
	* 退货人姓名
	*/
		@ApiModelProperty(value = "退货人姓名")
		private String returnName;
	/**
	* 退货人电话
	*/
		@ApiModelProperty(value = "退货人电话")
		private String returnPhone;
	/**
	* 申请状态[0->待处理；1->退货中；2->已完成；3->已拒绝]
	*/
		@ApiModelProperty(value = "申请状态[0->待处理；1->退货中；2->已完成；3->已拒绝]")
		private Boolean status;
	/**
	* 处理时间
	*/
		@ApiModelProperty(value = "处理时间")
		private LocalDateTime handleTime;
	/**
	* 商品图片
	*/
		@ApiModelProperty(value = "商品图片")
		private String skuImg;
	/**
	* 商品名称
	*/
		@ApiModelProperty(value = "商品名称")
		private String skuName;
	/**
	* 商品品牌
	*/
		@ApiModelProperty(value = "商品品牌")
		private String skuBrand;
	/**
	* 商品销售属性(JSON)
	*/
		@ApiModelProperty(value = "商品销售属性(JSON)")
		private String skuAttrsVals;
	/**
	* 退货数量
	*/
		@ApiModelProperty(value = "退货数量")
		private Integer skuCount;
	/**
	* 商品单价
	*/
		@ApiModelProperty(value = "商品单价")
		private BigDecimal skuPrice;
	/**
	* 商品实际支付单价
	*/
		@ApiModelProperty(value = "商品实际支付单价")
		private BigDecimal skuRealPrice;
	/**
	* 原因
	*/
		@ApiModelProperty(value = "原因")
		private String reason;
	/**
	* 描述
	*/
		@ApiModelProperty(value = "描述")
		private String description述;
	/**
	* 凭证图片，以逗号隔开
	*/
		@ApiModelProperty(value = "凭证图片，以逗号隔开")
		private String descPics;
	/**
	* 处理备注
	*/
		@ApiModelProperty(value = "处理备注")
		private String handleNote;
	/**
	* 处理人员
	*/
		@ApiModelProperty(value = "处理人员")
		private String handleMan;
	/**
	* 收货人
	*/
		@ApiModelProperty(value = "收货人")
		private String receiveMan;
	/**
	* 收货时间
	*/
		@ApiModelProperty(value = "收货时间")
		private LocalDateTime receiveTime;
	/**
	* 收货备注
	*/
		@ApiModelProperty(value = "收货备注")
		private String receiveNote;
	/**
	* 收货电话
	*/
		@ApiModelProperty(value = "收货电话")
		private String receivePhone;
	/**
	* 公司收货地址
	*/
		@ApiModelProperty(value = "公司收货地址")
		private String companyAddress;


}
