package com.fouo.common.to.es;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品在ES中保存的数据模型
 *
 * @author fouo
 * @date 2020/7/23 11:12
 */
@Data
public class SkuEsModel {
    private Long skuId;
    private Long spuId;
    private String skuTitle;
    private BigDecimal skuPrice;
    private String skuImg;
    /**
     * 销量
     */
    private Long saleCount;
    /**
     * 是否有库存
     */
    private Boolean hasStock;
    /**
     * 热度评分
     */
    private Long hotScore;
    /**
     * 品牌id
     */
    private Long brandId;
    /**
     * 分类id
     */
    private Long catalogId;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 品牌图片
     */
    private String brandImg;
    /**
     * 分类图片
     */
    private String catalogName;

    private List<Attrs> attrs;

    @Data
    public static class Attrs{
        private Long attrId;
        private String attrName;
        private String attrValue;
    }
}
