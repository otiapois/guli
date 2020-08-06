package com.fouo.product.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分类菜单
 * 三级分类VO节点实体
 *
 * @author fouo
 * @date 2020/7/28 16:06
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Catalog3VO {

    /**
     * 二级(父)分类id
     */
    private String catalog2Id;

    /**
     * 三级分类名称
     */
    private String name;
    /**
     * 三级分类节点Id
     */
    private String id;
}
