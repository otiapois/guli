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
 * 会员登录记录实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("ums_member_login_log")
@ApiModel(value = "MemberLoginLog对象", description = "会员登录记录")
public class MemberLoginLog implements Serializable {

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
	* 创建时间
	*/
		@ApiModelProperty(value = "创建时间")
		private LocalDateTime createTime;
	/**
	* ip
	*/
		@ApiModelProperty(value = "ip")
		private String ip;
	/**
	* city
	*/
		@ApiModelProperty(value = "city")
		private String city;
	/**
	* 登录类型[1-web，2-app]
	*/
		@ApiModelProperty(value = "登录类型[1-web，2-app]")
		private Boolean loginType;


}
