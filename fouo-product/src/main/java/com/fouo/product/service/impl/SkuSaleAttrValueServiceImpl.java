package com.fouo.product.service.impl;

import com.fouo.product.entity.SkuSaleAttrValue;
import com.fouo.product.vo.SkuSaleAttrValueVO;
import com.fouo.product.mapper.SkuSaleAttrValueMapper;
import com.fouo.product.service.ISkuSaleAttrValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fouo.product.vo.ext.ItemSaleAttrsVO;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * sku销售属性&值 服务实现类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Service
public class SkuSaleAttrValueServiceImpl extends ServiceImpl<SkuSaleAttrValueMapper, SkuSaleAttrValue> implements ISkuSaleAttrValueService {

	@Override
	public IPage<SkuSaleAttrValueVO> selectSkuSaleAttrValuePage(IPage<SkuSaleAttrValueVO> page, SkuSaleAttrValueVO skuSaleAttrValue) {
		return page.setRecords(baseMapper.selectSkuSaleAttrValuePage(page, skuSaleAttrValue));
	}

	@Override
	public List<ItemSaleAttrsVO> getSaleAttrsBySpuId(Long spuId) {
		return baseMapper.getSaleAttrsBySpuId(spuId);
	}
}
