package com.fouo.product.dto;

import com.fouo.product.entity.SkuInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * sku信息数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SkuInfoDTO extends SkuInfo {
	private static final long serialVersionUID = 1L;

}
