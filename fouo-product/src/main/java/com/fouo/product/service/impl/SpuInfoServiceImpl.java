package com.fouo.product.service.impl;

import com.fouo.common.to.SkuReductionTO;
import com.fouo.product.entity.*;
import com.fouo.product.feign.ICouponClient;
import com.fouo.product.mapper.SpuInfoDescMapper;
import com.fouo.product.service.*;
import com.fouo.product.vo.SpuInfoVO;
import com.fouo.product.mapper.SpuInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fouo.product.vo.ext.BaseAttrs;
import com.fouo.product.vo.ext.Bounds;
import com.fouo.product.vo.ext.Images;
import com.fouo.product.vo.ext.Skus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * spu信息 服务实现类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Service
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoMapper, SpuInfo> implements ISpuInfoService {

    @Autowired
    private ISpuInfoDescService iSpuInfoDescService;
    @Autowired
    private ISpuImagesService iSpuImagesService;
    @Autowired
    private IAttrService attrService;
    @Autowired
    private IProductAttrValueService iProductAttrValueService;
    @Autowired
    private ISkuInfoService iSkuInfoService;
    @Autowired
    private ISkuImagesService iSkuImagesService;
    @Autowired
    private ISkuSaleAttrValueService iSkuSaleAttrValueService;
    @Autowired
    private ICouponClient iCouponClient;

    @Override
    public IPage<SpuInfoVO> selectSpuInfoPage(IPage<SpuInfoVO> page, SpuInfoVO spuInfo) {
        List<SpuInfoVO> list = baseMapper.selectSpuInfoPage(page, spuInfo);
        page.setTotal(list.size());
        return page.setRecords(list);
    }

    @Transactional
    @Override
    public boolean saveSpuInfo(SpuInfoVO spuInfoVO) {
        //保存spu基本信息 pms_spu_info
        SpuInfo spuInfo = new SpuInfo();
        BeanUtils.copyProperties(spuInfoVO, spuInfo);
        //设置创建时间
        spuInfo.setCreateTime(LocalDateTime.now());
        //创建更新时间
        spuInfo.setUpdateTime(LocalDateTime.now());
        this.saveBaseSpuInfo(spuInfo);


        //保存spu的描述图片 pms_spu_info_desc
        List<String> decript = spuInfoVO.getDecript();
        SpuInfoDesc spuInfoDesc = new SpuInfoDesc();
        spuInfoDesc.setSpuId(spuInfo.getId());
        spuInfoDesc.setDecript(String.join(",", decript));
        iSpuInfoDescService.save(spuInfoDesc);


        //保存spu的图片集 pms_spu_images
        List<String> images = spuInfoVO.getImages();
        iSpuImagesService.saveImages(spuInfo.getId(), images);


        //保存spu的规格参数  pms_product_attr_value
        List<BaseAttrs> baseAttrs = spuInfoVO.getBaseAttrs();
        List<ProductAttrValue> collect = baseAttrs.stream().map(attr -> {
            ProductAttrValue attrValue = new ProductAttrValue();
            attrValue.setAttrId(attr.getAttrId());
            Attr bean = attrService.getById(attr.getAttrId());
            attrValue.setAttrName(bean.getAttrName());
            attrValue.setAttrValue(attr.getAttrValues());
            attrValue.setQuickShow(attr.getShowDesc());
            attrValue.setSpuId(spuInfoVO.getId());
            return attrValue;
        }).collect(Collectors.toList());
        iProductAttrValueService.saveBatch(collect);

        //保存当前spu对应的所有sku信息
        List<Skus> skus = spuInfoVO.getSkus();

        //保存sku的基本信息 pms_sku_info
        if (skus != null && skus.size() > 0) {
            skus.forEach(item -> {
                String defaultImage = "";
                for (Images image:item.getImages() ){
                    defaultImage = image.getImgUrl();
                }
                SkuInfo skuInfo = new SkuInfo();
                BeanUtils.copyProperties(item, skuInfo);
                skuInfo.setBrandId(spuInfo.getBrandId());
                skuInfo.setCatelogId(spuInfo.getCatelogId());
                skuInfo.setSaleCount(0L);
                skuInfo.setSpuId(spuInfo.getId());
                skuInfo.setSkuDefaultImg(defaultImage);
                iSkuInfoService.save(skuInfo);

                Long skuId = skuInfo.getSkuId();
                List<SkuImages> skuImagesList = item.getImages().stream().map(img -> {
                    SkuImages skuImages = new SkuImages();
                    skuImages.setSkuId(skuId);
                    skuImages.setImgUrl(img.getImgUrl());
                    skuImages.setDefaultImg(img.getDefaultImg());
                    return skuImages;
                }).filter(entity->{
                    return !StringUtils.isEmpty(entity.getImgUrl());
                }).collect(Collectors.toList());
                //保存sku的图片信息 pms_sku_images
                iSkuImagesService.saveBatch(skuImagesList);
                //保存sku的销售属性信息 pms_sku_sale_attr_value
                List<Attr> attr = item.getAttr();

                List<SkuSaleAttrValue> skuSaleAttrValues = attr.stream().map(entity -> {
                    SkuSaleAttrValue skuSaleAttrValue = new SkuSaleAttrValue();
                    BeanUtils.copyProperties(entity, skuSaleAttrValue);
                    skuSaleAttrValue.setSkuId(skuId);
                    return skuSaleAttrValue;
                }).collect(Collectors.toList());
                //批量保存
                iSkuSaleAttrValueService.saveBatch(skuSaleAttrValues);

                //保存spu的积分信息 sms_spu_bounds
                Bounds bounds = spuInfoVO.getBounds();
                bounds.setSpuId(spuInfo.getId());
                iCouponClient.saveSpuBounds(bounds);
                //保存sku的优惠、满减等信息 sms_sku_ladder（打折） sms_sku_full_reduction（满减） sms_member_price
                SkuReductionTO skuReductionTO = new SkuReductionTO();
                BeanUtils.copyProperties(item, skuReductionTO);
                skuReductionTO.setSkuId(skuId);
                if(skuReductionTO.getFullCount()>0 || skuReductionTO.getFullPrice().compareTo(new BigDecimal(0))==1){
                    iCouponClient.saveSkuReduction(skuReductionTO);
                }
            });

        }

        return true;
    }

    @Override
    public boolean saveBaseSpuInfo(SpuInfo spuInfo) {
        int index = baseMapper.insert(spuInfo);
        if (index > 0) {
            return true;
        }
        return false;
    }

}
