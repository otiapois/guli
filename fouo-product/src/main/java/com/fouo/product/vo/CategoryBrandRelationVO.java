package com.fouo.product.vo;

import com.fouo.product.entity.CategoryBrandRelation;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 品牌&分类关联视图实体类
 *
 * @author fouo
 * @since 2020-06-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "CategoryBrandRelationVO对象", description = "品牌&分类关联")
public class CategoryBrandRelationVO extends CategoryBrandRelation {
    private static final long serialVersionUID = 1L;
}
