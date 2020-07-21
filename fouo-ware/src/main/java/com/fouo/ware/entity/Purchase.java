package com.fouo.ware.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 采购信息实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@TableName("wms_purchase")
@ApiModel(value = "Purchase对象", description = "采购信息")
public class Purchase implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	private Long assigneeId;
	private String assigneeName;
	private String phone;
	private Integer priority;
	private Integer status;
	private Long wareId;
	private BigDecimal amount;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updateTime;
	/**
	 * 是否已删除
	 */
	@ApiModelProperty(value = "是否已删除")
	@TableLogic
	private Integer isDeleted;

}
