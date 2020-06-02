package com.fouo.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * spu图片实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@TableName("pms_spu_images")
@ApiModel(value = "SpuImages对象", description = "spu图片")
public class SpuImages implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
		@ApiModelProperty(value = "id")
		@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* spu_id
	*/
		@ApiModelProperty(value = "spu_id")
		private Long spuId;
	/**
	* 图片名
	*/
		@ApiModelProperty(value = "图片名")
		private String imgName;
	/**
	* 图片地址
	*/
		@ApiModelProperty(value = "图片地址")
		private String imgUrl;
	/**
	* 顺序
	*/
		@ApiModelProperty(value = "顺序")
		private Integer imgSort;
	/**
	* 是否默认图
	*/
		@ApiModelProperty(value = "是否默认图")
		private Integer defaultImg;


}
