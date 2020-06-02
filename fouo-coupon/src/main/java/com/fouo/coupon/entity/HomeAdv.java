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
 * 首页轮播广告实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("sms_home_adv")
@ApiModel(value = "HomeAdv对象", description = "首页轮播广告")
public class HomeAdv implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
		@ApiModelProperty(value = "id")
		@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* 名字
	*/
		@ApiModelProperty(value = "名字")
		private String name;
	/**
	* 图片地址
	*/
		@ApiModelProperty(value = "图片地址")
		private String pic;
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
	* 状态
	*/
		@ApiModelProperty(value = "状态")
		private Boolean status;
	/**
	* 点击数
	*/
		@ApiModelProperty(value = "点击数")
		private Integer clickCount;
	/**
	* 广告详情连接地址
	*/
		@ApiModelProperty(value = "广告详情连接地址")
		private String url;
	/**
	* 备注
	*/
		@ApiModelProperty(value = "备注")
		private String note;
	/**
	* 排序
	*/
		@ApiModelProperty(value = "排序")
		private Integer sort;
	/**
	* 发布者
	*/
		@ApiModelProperty(value = "发布者")
		private Long publisherId;
	/**
	* 审核者
	*/
		@ApiModelProperty(value = "审核者")
		private Long authId;


}
