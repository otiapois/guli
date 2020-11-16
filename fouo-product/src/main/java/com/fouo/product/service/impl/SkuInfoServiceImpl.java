package com.fouo.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fouo.product.entity.SkuImages;
import com.fouo.product.entity.SkuInfo;
import com.fouo.product.entity.SpuInfoDesc;
import com.fouo.product.service.*;
import com.fouo.product.vo.SkuInfoVO;
import com.fouo.product.mapper.SkuInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fouo.product.vo.ext.ItemSaleAttrsVO;
import com.fouo.product.vo.ext.SkuItemVO;
import com.fouo.product.vo.ext.SpuItemAttrGroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * sku信息 服务实现类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo> implements ISkuInfoService {
    @Autowired
    private ISkuImagesService iSkuImagesService;
    @Autowired
    private ISpuInfoDescService iSpuInfoDescService;
    @Autowired
    private IAttrGroupService iAttrGroupService;
    @Autowired
    private ISkuSaleAttrValueService iSkuSaleAttrValueService;

    @Override
    public IPage<SkuInfoVO> selectSkuInfoPage(IPage<SkuInfoVO> page, SkuInfoVO skuInfo) {
        return page.setRecords(baseMapper.selectSkuInfoPage(page, skuInfo));
    }

    @Override
    public List<SkuInfo> getSkusBySpuId(Long spuId) {
        List<SkuInfo> list = this.list(new QueryWrapper<SkuInfo>().eq("spu_id", spuId));
        return list;
    }

    @Override
    public SkuItemVO item(Long skuId) {
        SkuItemVO itemVO = new SkuItemVO();
        // 获取sku的基本信息 sku_info
        SkuInfo skuInfo = getById(skuId);
        Long spuId = skuInfo.getSpuId();
        Long catelogId = skuInfo.getCatelogId();
        itemVO.setSkuInfo(skuInfo);

        // 获取sku的图片信息  sku_images
        List<SkuImages> images = iSkuImagesService.getImagesBySkuId(skuId);
        itemVO.setImages(images);

        // 获取spu的销售属性组合
        List<ItemSaleAttrsVO> saleAttrsVOS = iSkuSaleAttrValueService.getSaleAttrsBySpuId(spuId);
        itemVO.setSaleAttr(saleAttrsVOS);

        // 获取spu的介绍
        SpuInfoDesc spuInfoDesc = iSpuInfoDescService.getById(spuId);
        itemVO.setSpuInfoDesc(spuInfoDesc);

        // 获取spu的规格参数信息
        List<SpuItemAttrGroupVO> attrGroupVOS = iAttrGroupService.getAttrGroupWithAttrsBySpuId(spuId, catelogId);
        itemVO.setGroupsAttrs(attrGroupVOS);

        return itemVO;
    }

}
