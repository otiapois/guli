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
 * sku销售属性&值实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@TableName("pms_sku_sale_attr_value")
@ApiModel(value = "SkuSaleAttrValue对象", description = "sku销售属性&值")
public class SkuSaleAttrValue implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
		@ApiModelProperty(value = "id")
		@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* sku_id
	*/
		@ApiModelProperty(value = "sku_id")
		private Long skuId;
	/**
	* attr_id
	*/
		@ApiModelProperty(value = "attr_id")
		private Long attrId;
	/**
	* 销售属性名
	*/
		@ApiModelProperty(value = "销售属性名")
		private String attrName;
	/**
	* 销售属性值
	*/
		@ApiModelProperty(value = "销售属性值")
		private String attrValue;
	/**
	* 顺序
	*/
		@ApiModelProperty(value = "顺序")
		private Integer attrSort;


}
