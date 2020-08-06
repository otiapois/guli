package com.fouo.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fouo.product.entity.SkuInfo;
import com.fouo.product.vo.SkuInfoVO;
import com.fouo.product.mapper.SkuInfoMapper;
import com.fouo.product.service.ISkuInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

	@Override
	public IPage<SkuInfoVO> selectSkuInfoPage(IPage<SkuInfoVO> page, SkuInfoVO skuInfo) {
		return page.setRecords(baseMapper.selectSkuInfoPage(page, skuInfo));
	}

	@Override
	public List<SkuInfo> getSkusBySpuId(Long spuId) {
		List<SkuInfo> list = this.list(new QueryWrapper<SkuInfo>().eq("spu_id", spuId));
		return list;
	}

}
