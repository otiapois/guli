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
 * 秒杀活动商品关联实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("sms_seckill_sku_relation")
@ApiModel(value = "SeckillSkuRelation对象", description = "秒杀活动商品关联")
public class SeckillSkuRelation implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
		@ApiModelProperty(value = "id")
		@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* 活动id
	*/
		@ApiModelProperty(value = "活动id")
		private Long promotionId;
	/**
	* 活动场次id
	*/
		@ApiModelProperty(value = "活动场次id")
		private Long promotionSessionId;
	/**
	* 商品id
	*/
		@ApiModelProperty(value = "商品id")
		private Long skuId;
	/**
	* 秒杀价格
	*/
		@ApiModelProperty(value = "秒杀价格")
		private BigDecimal seckillPrice;
	/**
	* 秒杀总量
	*/
		@ApiModelProperty(value = "秒杀总量")
		private BigDecimal seckillCount;
	/**
	* 每人限购数量
	*/
		@ApiModelProperty(value = "每人限购数量")
		private BigDecimal seckillLimit;
	/**
	* 排序
	*/
		@ApiModelProperty(value = "排序")
		private Integer seckillSort;


}
