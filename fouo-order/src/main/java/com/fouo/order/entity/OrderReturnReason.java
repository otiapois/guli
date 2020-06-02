package com.fouo.order.entity;

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
 * 退货原因实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("oms_order_return_reason")
@ApiModel(value = "OrderReturnReason对象", description = "退货原因")
public class OrderReturnReason implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
		@ApiModelProperty(value = "id")
		@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* 退货原因名
	*/
		@ApiModelProperty(value = "退货原因名")
		private String name;
	/**
	* 排序
	*/
		@ApiModelProperty(value = "排序")
		private Integer sort;
	/**
	* 启用状态
	*/
		@ApiModelProperty(value = "启用状态")
		private Boolean status;
	/**
	* create_time
	*/
		@ApiModelProperty(value = "create_time")
		private LocalDateTime createTime;


}
