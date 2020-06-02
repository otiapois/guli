package com.fouo.product.vo;

import com.fouo.product.entity.Attr;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品属性视图实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "AttrVO对象", description = "商品属性")
public class AttrVO extends Attr {
	private static final long serialVersionUID = 1L;

}
