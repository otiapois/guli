package com.fouo.product.service;

import com.fouo.product.entity.SkuSaleAttrValue;
import com.fouo.product.vo.SkuSaleAttrValueVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.product.vo.ext.ItemSaleAttrsVO;

import java.util.List;

/**
 * sku销售属性&值 服务类
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface ISkuSaleAttrValueService extends IService<SkuSaleAttrValue> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param skuSaleAttrValue
	 * @return
	 */
	IPage<SkuSaleAttrValueVO> selectSkuSaleAttrValuePage(IPage<SkuSaleAttrValueVO> page, SkuSaleAttrValueVO skuSaleAttrValue);

	/**
	 * 根据spuId获取销售属性
	 * @param spuId
	 * @return
	 */
    List<ItemSaleAttrsVO> getSaleAttrsBySpuId(Long spuId);
}
