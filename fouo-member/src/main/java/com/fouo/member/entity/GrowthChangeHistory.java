package com.fouo.member.entity;

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
 * 成长值变化历史记录实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("ums_growth_change_history")
@ApiModel(value = "GrowthChangeHistory对象", description = "成长值变化历史记录")
public class GrowthChangeHistory implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
		@ApiModelProperty(value = "id")
		@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* member_id
	*/
		@ApiModelProperty(value = "member_id")
		private Long memberId;
	/**
	* create_time
	*/
		@ApiModelProperty(value = "create_time")
		private LocalDateTime createTime;
	/**
	* 改变的值（正负计数）
	*/
		@ApiModelProperty(value = "改变的值（正负计数）")
		private Integer changeCount;
	/**
	* 备注
	*/
		@ApiModelProperty(value = "备注")
		private String note;
	/**
	* 积分来源[0-购物，1-管理员修改]
	*/
		@ApiModelProperty(value = "积分来源[0-购物，1-管理员修改]")
		private Integer sourceType;


}
