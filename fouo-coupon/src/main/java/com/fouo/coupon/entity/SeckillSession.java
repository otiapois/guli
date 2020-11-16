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
 * 秒杀活动场次实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("sms_seckill_session")
@ApiModel(value = "SeckillSession对象", description = "秒杀活动场次")
public class SeckillSession implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
		@ApiModelProperty(value = "id")
		@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* 场次名称
	*/
		@ApiModelProperty(value = "场次名称")
		private String name;
	/**
	* 每日开始时间
	*/
		@ApiModelProperty(value = "每日开始时间")
		private LocalDateTime startTime;
	/**
	* 每日结束时间
	*/
		@ApiModelProperty(value = "每日结束时间")
		private LocalDateTime endTime;
	/**
	* 启用状态
	*/
		@ApiModelProperty(value = "启用状态")
		private Boolean status;
	/**
	* 创建时间
	*/
		@ApiModelProperty(value = "创建时间")
		private LocalDateTime createTime;


}
