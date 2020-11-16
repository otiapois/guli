package com.fouo.member.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员收藏的商品实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("ums_member_collect_spu")
@ApiModel(value = "MemberCollectSpu对象", description = "会员收藏的商品")
public class MemberCollectSpu implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
		@ApiModelProperty(value = "id")
		private Long id;
	/**
	* 会员id
	*/
		@ApiModelProperty(value = "会员id")
		private Long memberId;
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
	/**
	* spu_img
	*/
		@ApiModelProperty(value = "spu_img")
		private String spuImg;
	/**
	* create_time
	*/
		@ApiModelProperty(value = "create_time")
		private LocalDateTime createTime;


}
