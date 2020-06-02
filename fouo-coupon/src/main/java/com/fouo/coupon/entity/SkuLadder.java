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
 * 商品阶梯价格实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("sms_sku_ladder")
@ApiModel(value = "SkuLadder对象", description = "商品阶梯价格")
public class SkuLadder implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
		@ApiModelProperty(value = "id")
		@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* spu_id
	*/
		@ApiModelProperty(value = "spu_id")
		private Long skuId;
	/**
	* 满几件
	*/
		@ApiModelProperty(value = "满几件")
		private Integer fullCount;
	/**
	* 打几折
	*/
		@ApiModelProperty(value = "打几折")
		private BigDecimal discount;
	/**
	* 折后价
	*/
		@ApiModelProperty(value = "折后价")
		private BigDecimal price;
	/**
	* 是否叠加其他优惠[0-不可叠加，1-可叠加]
	*/
		@ApiModelProperty(value = "是否叠加其他优惠[0-不可叠加，1-可叠加]")
		private Boolean addOther;


}
