package com.fouo.ware.vo;

import com.fouo.ware.entity.PurchaseDetail;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "PurchaseDetailVO对象", description = "PurchaseDetailVO对象")
public class PurchaseDetailVO extends PurchaseDetail {
	private static final long serialVersionUID = 1L;

}
