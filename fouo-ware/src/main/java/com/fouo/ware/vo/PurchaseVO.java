package com.fouo.ware.vo;

import com.fouo.ware.entity.Purchase;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

import java.util.List;

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
    /**
     * 关键字
     */
    @ApiModelProperty(value = "关键字")
    private String searchKeyword;

	/**
	 * 采购单id
	 */
	@ApiModelProperty(value = "采购单id")
	private Long purchaseId;

	/**
	 * 采购想集合
	 */
	@ApiModelProperty(value = "采购想集合")
    private List<Long> items;


}
