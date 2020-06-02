package com.fouo.ware.vo;

import com.fouo.ware.entity.Purchase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 采购信息视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "PurchaseVO对象", description = "采购信息")
public class PurchaseVO extends Purchase {
	private static final long serialVersionUID = 1L;

}
