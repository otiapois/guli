package com.fouo.coupon.service.impl;

import com.fouo.coupon.entity.SkuBounds;
import com.fouo.coupon.vo.SkuBoundsVO;
import com.fouo.coupon.mapper.SkuBoundsMapper;
import com.fouo.coupon.service.ISkuBoundsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品sku积分设置 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class SkuBoundsServiceImpl extends ServiceImpl<SkuBoundsMapper, SkuBounds> implements ISkuBoundsService {

	@Override
	public IPage<SkuBoundsVO> selectSkuBoundsPage(IPage<SkuBoundsVO> page, SkuBoundsVO skuBounds) {
		return page.setRecords(baseMapper.selectSkuBoundsPage(page, skuBounds));
	}

}
