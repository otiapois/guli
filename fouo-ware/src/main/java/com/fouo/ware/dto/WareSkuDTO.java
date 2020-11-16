package com.fouo.ware.dto;

import com.fouo.ware.entity.WareSku;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品库存数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WareSkuDTO extends WareSku {
	private static final long serialVersionUID = 1L;

}
