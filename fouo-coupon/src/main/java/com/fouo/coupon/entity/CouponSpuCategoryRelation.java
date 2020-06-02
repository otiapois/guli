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
 * 优惠券分类关联实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("sms_coupon_spu_category_relation")
@ApiModel(value = "CouponSpuCategoryRelation对象", description = "优惠券分类关联")
public class CouponSpuCategoryRelation implements Serializable {

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
	* 产品分类id
	*/
		@ApiModelProperty(value = "产品分类id")
		private Long categoryId;
	/**
	* 产品分类名称
	*/
		@ApiModelProperty(value = "产品分类名称")
		private String categoryName;


}
