package com.fouo.product.service.impl;

import com.fouo.product.entity.SkuInfo;
import com.fouo.product.vo.SkuInfoVO;
import com.fouo.product.mapper.SkuInfoMapper;
import com.fouo.product.service.ISkuInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * sku信息 服务实现类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo> implements ISkuInfoService {

	@Override
	public IPage<SkuInfoVO> selectSkuInfoPage(IPage<SkuInfoVO> page, SkuInfoVO skuInfo) {
		return page.setRecords(baseMapper.selectSkuInfoPage(page, skuInfo));
	}

}
