package com.fouo.ware.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("wms_purchase_detail")
@ApiModel(value = "PurchaseDetail对象", description = "PurchaseDetail对象")
public class PurchaseDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* 采购单id
	*/
		@ApiModelProperty(value = "采购单id")
		private Long purchaseId;
	/**
	* 采购商品id
	*/
		@ApiModelProperty(value = "采购商品id")
		private Long skuId;
	/**
	* 采购数量
	*/
		@ApiModelProperty(value = "采购数量")
		private Integer skuNum;
	/**
	* 采购金额
	*/
		@ApiModelProperty(value = "采购金额")
		private BigDecimal skuPrice;
	/**
	* 仓库id
	*/
		@ApiModelProperty(value = "仓库id")
		private Long wareId;
	/**
	* 状态[0新建，1已分配，2正在采购，3已完成，4采购失败]
	*/
		@ApiModelProperty(value = "状态[0新建，1已分配，2正在采购，3已完成，4采购失败]")
		private Integer status;


}
