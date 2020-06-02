package com.fouo.product.vo;

import com.fouo.product.entity.AttrAttrgroupRelation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 属性&属性分组关联视图实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "AttrAttrgroupRelationVO对象", description = "属性&属性分组关联")
public class AttrAttrgroupRelationVO extends AttrAttrgroupRelation {
	private static final long serialVersionUID = 1L;

}
