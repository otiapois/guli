package com.fouo.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fouo.product.entity.SkuImages;
import com.fouo.product.vo.SkuImagesVO;
import com.fouo.product.mapper.SkuImagesMapper;
import com.fouo.product.service.ISkuImagesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * sku图片 服务实现类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Service
public class SkuImagesServiceImpl extends ServiceImpl<SkuImagesMapper, SkuImages> implements ISkuImagesService {

	@Override
	public IPage<SkuImagesVO> selectSkuImagesPage(IPage<SkuImagesVO> page, SkuImagesVO skuImages) {
		return page.setRecords(baseMapper.selectSkuImagesPage(page, skuImages));
	}

	@Override
	public List<SkuImages> getImagesBySkuId(Long skuId) {
		return baseMapper.selectList(new QueryWrapper<SkuImages>().eq("sku_id", skuId));
	}

}
