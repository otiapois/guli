package com.fouo.ware.dto;

import com.fouo.ware.entity.Purchase;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 采购信息数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PurchaseDTO extends Purchase {
	private static final long serialVersionUID = 1L;

}
