package com.fouo.member.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员收藏的专题活动实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("ums_member_collect_subject")
@ApiModel(value = "MemberCollectSubject对象", description = "会员收藏的专题活动")
public class MemberCollectSubject implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
		@ApiModelProperty(value = "id")
		@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* subject_id
	*/
		@ApiModelProperty(value = "subject_id")
		private Long subjectId;
	/**
	* subject_name
	*/
		@ApiModelProperty(value = "subject_name")
		private String subjectName;
	/**
	* subject_img
	*/
		@ApiModelProperty(value = "subject_img")
		private String subjectImg;
	/**
	* 活动url
	*/
		@ApiModelProperty(value = "活动url")
		private String subjectUrll;


}
