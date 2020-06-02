package com.fouo.coupon.entity;

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
 * 优惠券信息实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("sms_coupon")
@ApiModel(value = "Coupon对象", description = "优惠券信息")
public class Coupon implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
		@ApiModelProperty(value = "id")
		@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* 优惠卷类型[0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券]
	*/
		@ApiModelProperty(value = "优惠卷类型[0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券]")
		private Boolean couponType;
	/**
	* 优惠券图片
	*/
		@ApiModelProperty(value = "优惠券图片")
		private String couponImg;
	/**
	* 优惠卷名字
	*/
		@ApiModelProperty(value = "优惠卷名字")
		private String couponName;
	/**
	* 数量
	*/
		@ApiModelProperty(value = "数量")
		private Integer num;
	/**
	* 金额
	*/
		@ApiModelProperty(value = "金额")
		private BigDecimal amount;
	/**
	* 每人限领张数
	*/
		@ApiModelProperty(value = "每人限领张数")
		private Integer perLimit;
	/**
	* 使用门槛
	*/
		@ApiModelProperty(value = "使用门槛")
		private BigDecimal minPoint;
	/**
	* 开始时间
	*/
		@ApiModelProperty(value = "开始时间")
		private LocalDateTime startTime;
	/**
	* 结束时间
	*/
		@ApiModelProperty(value = "结束时间")
		private LocalDateTime endTime;
	/**
	* 使用类型[0->全场通用；1->指定分类；2->指定商品]
	*/
		@ApiModelProperty(value = "使用类型[0->全场通用；1->指定分类；2->指定商品]")
		private Boolean useType;
	/**
	* 备注
	*/
		@ApiModelProperty(value = "备注")
		private String note;
	/**
	* 发行数量
	*/
		@ApiModelProperty(value = "发行数量")
		private Integer publishCount;
	/**
	* 已使用数量
	*/
		@ApiModelProperty(value = "已使用数量")
		private Integer useCount;
	/**
	* 领取数量
	*/
		@ApiModelProperty(value = "领取数量")
		private Integer receiveCount;
	/**
	* 可以领取的开始日期
	*/
		@ApiModelProperty(value = "可以领取的开始日期")
		private LocalDateTime enableStartTime;
	/**
	* 可以领取的结束日期
	*/
		@ApiModelProperty(value = "可以领取的结束日期")
		private LocalDateTime enableEndTime;
	/**
	* 优惠码
	*/
		@ApiModelProperty(value = "优惠码")
		private String code;
	/**
	* 可以领取的会员等级[0->不限等级，其他-对应等级]
	*/
		@ApiModelProperty(value = "可以领取的会员等级[0->不限等级，其他-对应等级]")
		private Boolean memberLevel;
	/**
	* 发布状态[0-未发布，1-已发布]
	*/
		@ApiModelProperty(value = "发布状态[0-未发布，1-已发布]")
		private Boolean publish;


}
