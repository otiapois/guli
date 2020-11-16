package com.fouo.search.vo;

import lombok.Data;

import java.util.List;

/**
 * 查询实体类
 * 封装页面检索条件
 * @author fouo
 * @date 2020/8/7 16:12
 */
@Data
public class SearchParam {
    /**
     * 页面传递过来的全文匹配关键字
     * 用做全文检索使用
     */
    private String keyword;
    /**
     * 三级分类id
     */
    private Long catalog3Id;

    /**
     * 排序字段
     * sort=saleCount_asc/desc
     * sort=skuPrice_asc/desc
     * sort=hotScore_asc/desc
     */
    private String sort;

    /**
     * 过滤条件
     * hasStock(是否有货) hasStock = 0/1
     * skuPrice(价格区间) skuPrice = 1_500/_500/500_
     * brandId(品牌id) 支持选择多个品牌
     * attrs(属性) 按照属性进行筛选
     * pageNum 页码
     */
    private Integer hasStock =1;
    private String skuPrice;
    private List<Long> brandId;
    private List<String> attrs;
    private Integer pageNum =1;
}
