package com.fouo.ware.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fouo.ware.entity.WareSku;
import com.fouo.ware.vo.SkuHasStockV0;
import com.fouo.ware.vo.WareSkuVO;
import com.fouo.ware.mapper.WareSkuMapper;
import com.fouo.ware.service.IWareSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品库存 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class WareSkuServiceImpl extends ServiceImpl<WareSkuMapper, WareSku> implements IWareSkuService {

	@Override
	public IPage<WareSkuVO> selectWareSkuPage(IPage<WareSkuVO> page, WareSkuVO wareSku) {
		return page.setRecords(baseMapper.selectWareSkuPage(page, wareSku));
	}

	@Transactional
	@Override
	public void addStock(Long skuId, Long wareId, Integer skuNum) {
		// 如果没有则为 新增 如果有了则为更新
		List<WareSku> wareSkus = baseMapper.selectList(new QueryWrapper<WareSku>().eq("sku_id", skuId).eq("ware_id", wareId));
		if(wareSkus ==null || wareSkus.size() == 0){
			WareSku wareSku = new WareSku();
			wareSku.setId(skuId);
			wareSku.setWareId(wareId);
			wareSku.setStock(skuNum);
			wareSku.setStockLocked(0);
			//TODO 远程查询skuName
			wareSku.setSkuName("");
			baseMapper.insert(wareSku);
		}
		this.baseMapper.addStock(skuId,wareId,skuNum);
	}

	@Override
	public List<SkuHasStockV0> getSkusHasStock(List<Long> skuIds) {
		List<SkuHasStockV0> collect = skuIds.stream().map(skuId -> {
			SkuHasStockV0 skuHasStockV0 = new SkuHasStockV0();
			//查询当前sku的总库存量
			Long count = baseMapper.selectSkuStock(skuId);
			skuHasStockV0.setSkuId(skuId);
			if(count >0){
				skuHasStockV0.setHasStock(true);
			}else{
				skuHasStockV0.setHasStock(false);
			}
			return skuHasStockV0;
		}).collect(Collectors.toList());
		return collect;
	}

}
