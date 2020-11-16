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
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("sms_home_subject")
@ApiModel(value = "HomeSubject对象", description = "首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】")
public class HomeSubject implements Serializable {

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
	* 专题标题
	*/
		@ApiModelProperty(value = "专题标题")
		private String title;
	/**
	* 专题副标题
	*/
		@ApiModelProperty(value = "专题副标题")
		private String subTitle;
	/**
	* 显示状态
	*/
		@ApiModelProperty(value = "显示状态")
		private Boolean status;
	/**
	* 详情连接
	*/
		@ApiModelProperty(value = "详情连接")
		private String url;
	/**
	* 排序
	*/
		@ApiModelProperty(value = "排序")
		private Integer sort;
	/**
	* 专题图片地址
	*/
		@ApiModelProperty(value = "专题图片地址")
		private String img;


}
