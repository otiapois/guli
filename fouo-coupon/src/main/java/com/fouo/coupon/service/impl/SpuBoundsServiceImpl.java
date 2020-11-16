package com.fouo.coupon.service.impl;

import com.fouo.coupon.entity.SpuBounds;
import com.fouo.coupon.vo.SpuBoundsVO;
import com.fouo.coupon.mapper.SpuBoundsMapper;
import com.fouo.coupon.service.ISpuBoundsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品spu积分设置 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class SpuBoundsServiceImpl extends ServiceImpl<SpuBoundsMapper, SpuBounds> implements ISpuBoundsService {

	@Override
	public IPage<SpuBoundsVO> selectSpuBoundsPage(IPage<SpuBoundsVO> page, SpuBoundsVO spuBounds) {
		return page.setRecords(baseMapper.selectSpuBoundsPage(page, spuBounds));
	}

}
