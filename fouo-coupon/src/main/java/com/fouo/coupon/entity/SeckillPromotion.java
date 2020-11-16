package com.fouo.coupon.entity;

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
 * 秒杀活动实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("sms_seckill_promotion")
@ApiModel(value = "SeckillPromotion对象", description = "秒杀活动")
public class SeckillPromotion implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
		@ApiModelProperty(value = "id")
		@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* 活动标题
	*/
		@ApiModelProperty(value = "活动标题")
		private String title;
	/**
	* 开始日期
	*/
		@ApiModelProperty(value = "开始日期")
		private LocalDateTime startTime;
	/**
	* 结束日期
	*/
		@ApiModelProperty(value = "结束日期")
		private LocalDateTime endTime;
	/**
	* 上下线状态
	*/
		@ApiModelProperty(value = "上下线状态")
		private Integer status;
	/**
	* 创建时间
	*/
		@ApiModelProperty(value = "创建时间")
		private LocalDateTime createTime;
	/**
	* 创建人
	*/
		@ApiModelProperty(value = "创建人")
		private Long userId;


}
