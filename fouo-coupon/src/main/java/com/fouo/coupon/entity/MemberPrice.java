package com.fouo.coupon.entity;

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
 * 商品会员价格实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("sms_member_price")
@ApiModel(value = "MemberPrice对象", description = "商品会员价格")
public class MemberPrice implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
		@ApiModelProperty(value = "id")
		@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* sku_id
	*/
		@ApiModelProperty(value = "sku_id")
		private Long skuId;
	/**
	* 会员等级id
	*/
		@ApiModelProperty(value = "会员等级id")
		private Long memberLevelId;
	/**
	* 会员等级名
	*/
		@ApiModelProperty(value = "会员等级名")
		private String memberLevelName;
	/**
	* 会员对应价格
	*/
		@ApiModelProperty(value = "会员对应价格")
		private BigDecimal memberPrice;
	/**
	* 可否叠加其他优惠[0-不可叠加优惠，1-可叠加]
	*/
		@ApiModelProperty(value = "可否叠加其他优惠[0-不可叠加优惠，1-可叠加]")
		private Boolean addOther;


}
