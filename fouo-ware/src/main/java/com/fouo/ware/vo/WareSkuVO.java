package com.fouo.ware.vo;

import com.fouo.ware.entity.WareSku;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品库存视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "WareSkuVO对象", description = "商品库存")
public class WareSkuVO extends WareSku {
	private static final long serialVersionUID = 1L;

}
