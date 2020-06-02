package com.fouo.coupon.service.impl;

import com.fouo.coupon.entity.SkuFullReduction;
import com.fouo.coupon.vo.SkuFullReductionVO;
import com.fouo.coupon.mapper.SkuFullReductionMapper;
import com.fouo.coupon.service.ISkuFullReductionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品满减信息 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionMapper, SkuFullReduction> implements ISkuFullReductionService {

	@Override
	public IPage<SkuFullReductionVO> selectSkuFullReductionPage(IPage<SkuFullReductionVO> page, SkuFullReductionVO skuFullReduction) {
		return page.setRecords(baseMapper.selectSkuFullReductionPage(page, skuFullReduction));
	}

}
