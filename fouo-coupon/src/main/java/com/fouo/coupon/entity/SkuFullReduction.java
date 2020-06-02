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
 * 商品满减信息实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("sms_sku_full_reduction")
@ApiModel(value = "SkuFullReduction对象", description = "商品满减信息")
public class SkuFullReduction implements Serializable {

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
	* 满多少
	*/
		@ApiModelProperty(value = "满多少")
		private BigDecimal fullPrice;
	/**
	* 减多少
	*/
		@ApiModelProperty(value = "减多少")
		private BigDecimal reducePrice;
	/**
	* 是否参与其他优惠
	*/
		@ApiModelProperty(value = "是否参与其他优惠")
		private Boolean addOther;


}
