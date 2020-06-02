package com.fouo.product.dto;

import com.fouo.product.entity.SpuInfoDesc;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * spu信息介绍数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SpuInfoDescDTO extends SpuInfoDesc {
	private static final long serialVersionUID = 1L;

}
