package com.fouo.product.vo.ext;

import com.fouo.product.entity.SkuImages;
import com.fouo.product.entity.SkuInfo;
import com.fouo.product.entity.SpuInfo;
import com.fouo.product.entity.SpuInfoDesc;
import lombok.Data;

import java.util.List;

/**
 * 商品详情页封装实体类
 *
 * @author fouo
 * @date 2020/8/14 9:00
 */
@Data
public class SkuItemVO {
    //基本信息
    private SkuInfo skuInfo;
    //是否有货
    private boolean hasStock;
    //图片信息
    private List<SkuImages> images;
    //spu的销售属性的组合信息
    private List<ItemSaleAttrsVO> saleAttr;
    //spu的介绍信息
    private SpuInfoDesc spuInfoDesc;
    //spu的规格参数信息
    private List<SpuItemAttrGroupVO> groupsAttrs;
}
