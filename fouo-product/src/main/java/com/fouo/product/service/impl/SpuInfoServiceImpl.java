package com.fouo.product.service.impl;

import com.fouo.common.support.R;
import com.fouo.common.to.SkuReductionTO;
import com.fouo.common.to.es.SkuEsModel;
import com.fouo.product.entity.*;
import com.fouo.product.enums.StatusEnum;
import com.fouo.product.feign.ICouponClient;
import com.fouo.product.feign.IElasticSearchClient;
import com.fouo.product.feign.IWareClient;
import com.fouo.product.mapper.SpuInfoDescMapper;
import com.fouo.product.service.*;
import com.fouo.product.vo.SpuInfoVO;
import com.fouo.product.mapper.SpuInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fouo.product.vo.ext.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
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
    private IBrandService brandService;
    @Autowired
    private IProductAttrValueService iProductAttrValueService;
    @Autowired
    private ISkuInfoService iSkuInfoService;
    @Autowired
    private ISkuImagesService iSkuImagesService;
    @Autowired
    private ISkuSaleAttrValueService iSkuSaleAttrValueService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private ICouponClient iCouponClient;
    @Autowired
    private IWareClient iWareClient;
    @Autowired
    private IElasticSearchClient iElasticSearchClient;


    @Override
    public IPage<SpuInfoVO> selectSpuInfoPage(IPage<SpuInfoVO> page, SpuInfoVO spuInfo) {
        List<SpuInfoVO> list = baseMapper.selectSpuInfoPage(page, spuInfo);
//        page.setTotal(list.size());
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
            attrValue.setSpuId(spuInfo.getId());
            return attrValue;
        }).collect(Collectors.toList());
        iProductAttrValueService.saveBatch(collect);

        //保存当前spu对应的所有sku信息
        List<Skus> skus = spuInfoVO.getSkus();

        //保存sku的基本信息 pms_sku_info
        if (skus != null && skus.size() > 0) {
            skus.forEach(item -> {
                String defaultImage = "";
                for (Images image : item.getImages()) {
                    defaultImage = image.getImgUrl();
                }
                SkuInfo skuInfo = new SkuInfo();
                BeanUtils.copyProperties(item, skuInfo);
                skuInfo.setBrandId(spuInfo.getBrandId());
                skuInfo.setCatelogId(spuInfo.getCatalogId());
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
                }).filter(entity -> {
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
                if (skuReductionTO.getFullCount() > 0 || skuReductionTO.getFullPrice().compareTo(new BigDecimal(0)) == 1) {
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

    @Override
    public boolean up(Long spuId) {
        //根据当前spuid查询出所有的sku信息
        List<SkuInfo> skuInfos = iSkuInfoService.getSkusBySpuId(spuId);
        List<Long> skuIds = skuInfos.stream().map(SkuInfo::getSkuId).collect(Collectors.toList());

        //查询当前sku的所有可以被用来 可检索 的规格属性
        List<ProductAttrValue> spuList = iProductAttrValueService.getSpuList(spuId);

        List<Long> attrIds = spuList.stream().map(attr -> {
            return attr.getAttrId();
        }).collect(Collectors.toList());

        List<Long> searchAttrIds = attrService.selectSearchAttrs(attrIds);

        Set<Long> idSet = new HashSet<>(searchAttrIds);
        List<SkuEsModel.Attrs> attrs = new ArrayList<>();

        List<SkuEsModel.Attrs> attrsList = spuList.stream().filter(item -> {
            return idSet.contains(item.getAttrId());
        }).map(item -> {
            SkuEsModel.Attrs attrs1 = new SkuEsModel.Attrs();
            BeanUtils.copyProperties(item, attrs1);
            return attrs1;
        }).collect(Collectors.toList());

        Map<Long, Boolean> stockMap = null;
        try {
            //TODO 1、发送远程调用，库存系统查询是否有库存 ware服务
            R<List<SkuHasStockV0>> skusHasStock = iWareClient.getSkusHasStock(skuIds);
            stockMap = skusHasStock.getData().stream().collect(Collectors.toMap(SkuHasStockV0::getSkuId, item -> item.getHasStock()));

        } catch (Exception e) {
            log.error("库存服务查询异常：原因{}", e);
        }

        //给查询出的每个sku实体进行封装
        Map<Long, Boolean> finalStockMap = stockMap;
        List<SkuEsModel> skuEsModels = skuInfos.stream().map(sku -> {
            //组装需要的数据
            SkuEsModel skuEsModel = new SkuEsModel();
            BeanUtils.copyProperties(sku, skuEsModel);

            skuEsModel.setSkuPrice(sku.getPrice());
            skuEsModel.setSkuImg(sku.getSkuDefaultImg());

            //1、发送远程调用，库存系统查询是否有库存 ware服务
            if(finalStockMap ==null){
                skuEsModel.setHasStock(true);
            }else{
                skuEsModel.setHasStock(finalStockMap.get(sku.getSkuId()));
            }
            //TODO 2、热度评分
            skuEsModel.setHotScore(0L);

            //查询分类名称和品牌名称
            Brand brand = brandService.getById(sku.getBrandId());
            skuEsModel.setBrandName(brand.getName());
            skuEsModel.setBrandImg(brand.getLogo());
            Category category = categoryService.getById(sku.getCatelogId());
            skuEsModel.setCatalogName(category.getName());
            skuEsModel.setCatalogId(sku.getCatelogId());
            //设置attrs
            skuEsModel.setAttrs(attrsList);

            return skuEsModel;
        }).collect(Collectors.toList());

        // 将数据发送给ES进行保存 fouo-es
        R code = iElasticSearchClient.productStatusUp(skuEsModels);
        // TODO  重复调用？接口幂等性：重试机制?
        /**
         * Feign 调用流程
         *  1、构造请求数据，将对象转换为json
         *      buildTemplateFromArgs.create（argv）
         *  2、发送请求，进行执行,执行成功会解码数据
         *      executeAndDecode(template)
         *  3、
         */
        //保存成功
        if(code.getCode() == 200){
            baseMapper.updateSpuStatus(spuId, StatusEnum.SPU_UP.getCode());
            return true;
        }
        return false;
    }
}
