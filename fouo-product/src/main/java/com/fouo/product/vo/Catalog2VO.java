package com.fouo.product.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分类菜单
 * 二级分类VO节点实体
 *
 * @author fouo
 * @date 2020/7/28 16:06
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Catalog2VO {

    /**
     * 一级父分类Id
     */
    private String catalog1Id;
    /**
     * 三级子分类
     */
    private List<Catalog3VO> catalog3List;
    /**
     * 当前节点id
     */
    private String id;
    /**
     * 当前节点名称
     */
    private String name;


}
