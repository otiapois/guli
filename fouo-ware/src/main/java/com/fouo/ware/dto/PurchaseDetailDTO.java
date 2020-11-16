package com.fouo.ware.dto;

import com.fouo.ware.entity.PurchaseDetail;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PurchaseDetailDTO extends PurchaseDetail {
	private static final long serialVersionUID = 1L;

}
