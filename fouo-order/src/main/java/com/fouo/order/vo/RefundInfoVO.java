package com.fouo.order.vo;

import com.fouo.order.entity.RefundInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 退款信息视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "RefundInfoVO对象", description = "退款信息")
public class RefundInfoVO extends RefundInfo {
	private static final long serialVersionUID = 1L;

}
