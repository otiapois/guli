package com.fouo.ware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 库存工作单实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("wms_ware_order_task_detail")
@ApiModel(value = "WareOrderTaskDetail对象", description = "库存工作单")
public class WareOrderTaskDetail implements Serializable {

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
	* sku_name
	*/
		@ApiModelProperty(value = "sku_name")
		private String skuName;
	/**
	* 购买个数
	*/
		@ApiModelProperty(value = "购买个数")
		private Integer skuNum;
	/**
	* 工作单id
	*/
		@ApiModelProperty(value = "工作单id")
		private Long taskId;


}
