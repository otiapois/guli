package com.fouo.order.dto;

import com.fouo.order.entity.RefundInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 退款信息数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RefundInfoDTO extends RefundInfo {
	private static final long serialVersionUID = 1L;

}
