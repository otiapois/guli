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
 * 积分变化历史记录实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("ums_integration_change_history")
@ApiModel(value = "IntegrationChangeHistory对象", description = "积分变化历史记录")
public class IntegrationChangeHistory implements Serializable {

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
	* 变化的值
	*/
		@ApiModelProperty(value = "变化的值")
		private Integer changeCount;
	/**
	* 备注
	*/
		@ApiModelProperty(value = "备注")
		private String note;
	/**
	* 来源[0->购物；1->管理员修改;2->活动]
	*/
		@ApiModelProperty(value = "来源[0->购物；1->管理员修改;2->活动]")
		private Integer sourceTyoe;


}
