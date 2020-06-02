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
 * 专题商品实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("sms_home_subject_spu")
@ApiModel(value = "HomeSubjectSpu对象", description = "专题商品")
public class HomeSubjectSpu implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
		@ApiModelProperty(value = "id")
		@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* 专题名字
	*/
		@ApiModelProperty(value = "专题名字")
		private String name;
	/**
	* 专题id
	*/
		@ApiModelProperty(value = "专题id")
		private Long subjectId;
	/**
	* spu_id
	*/
		@ApiModelProperty(value = "spu_id")
		private Long spuId;
	/**
	* 排序
	*/
		@ApiModelProperty(value = "排序")
		private Integer sort;


}
