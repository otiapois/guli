package com.fouo.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 优惠券与产品关联实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("sms_coupon_spu_relation")
@ApiModel(value = "CouponSpuRelation对象", description = "优惠券与产品关联")
public class CouponSpuRelation implements Serializable {

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
	* spu_id
	*/
		@ApiModelProperty(value = "spu_id")
		private Long spuId;
	/**
	* spu_name
	*/
		@ApiModelProperty(value = "spu_name")
		private String spuName;


}
