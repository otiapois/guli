package com.fouo.search.vo;

import com.fouo.common.to.es.SkuEsModel;
import lombok.Data;

import java.util.List;

/**
 * 查询实体类
 * 页面请求返回参数实体类
 * 返回给页面的信息
 *
 * @author fouo
 * @date 2020/8/10 9:32
 */
@Data
public class SearchResult {
    /*
     * 查询到的所有商品信息
     */
    private List<SkuEsModel> products;

    /*
     * 封装分页信息
     */
    private Integer pageNum;
    private Long total;
    private Integer totalPages;//总页码

    private List<Integer> pageNavs;

    private List<BrandVO> brands;//当前查询到的结果，所有涉及到的品牌
    private List<AttrVO> attrs;//当前查询到的结果，所有涉及到的属性
    private List<CatalogVO> catalogs;//当前查询到的结果，所有涉及到的分类

    @Data
    public static class BrandVO {
        private Long brandId;
        private String brandName;
        private String brandImg;
    }

    @Data
    public static class AttrVO {
        private Long attrId;
        private String attrName;
        private List<String> attrValue;
    }

    @Data
    public static class CatalogVO {
        private Long catalogId;
        private String catalogName;
    }
}
