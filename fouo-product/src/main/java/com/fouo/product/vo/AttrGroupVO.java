package com.fouo.product.vo;

import com.fouo.product.entity.AttrGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 属性分组视图实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "AttrGroupVO对象", description = "属性分组")
public class AttrGroupVO extends AttrGroup {
	private static final long serialVersionUID = 1L;

}
