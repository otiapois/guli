package com.fouo.product.dto;

import com.fouo.product.entity.AttrAttrgroupRelation;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 属性&属性分组关联数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AttrAttrgroupRelationDTO extends AttrAttrgroupRelation {
	private static final long serialVersionUID = 1L;

}
