package com.fouo.product.dto;

import com.fouo.product.entity.Attr;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品属性数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AttrDTO extends Attr {
	private static final long serialVersionUID = 1L;

}
