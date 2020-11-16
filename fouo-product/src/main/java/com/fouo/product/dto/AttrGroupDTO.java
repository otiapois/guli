package com.fouo.product.dto;

import com.fouo.product.entity.AttrGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 属性分组数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AttrGroupDTO extends AttrGroup {
	private static final long serialVersionUID = 1L;

}
