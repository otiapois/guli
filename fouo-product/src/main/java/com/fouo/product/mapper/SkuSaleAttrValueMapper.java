package com.fouo.product.mapper;

import com.fouo.product.entity.SkuSaleAttrValue;
import com.fouo.product.vo.SkuSaleAttrValueVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.product.vo.ext.ItemSaleAttrsVO;

import java.util.List;

/**
 * sku销售属性&值 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface SkuSaleAttrValueMapper extends BaseMapper<SkuSaleAttrValue> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param skuSaleAttrValue
	 * @return
	 */
	List<SkuSaleAttrValueVO> selectSkuSaleAttrValuePage(IPage page, SkuSaleAttrValueVO skuSaleAttrValue);

	/**
	 * 根据spuId获取销售属性
	 * @param spuId
	 * @return
	 */
    List<ItemSaleAttrsVO> getSaleAttrsBySpuId(Long spuId);
}
