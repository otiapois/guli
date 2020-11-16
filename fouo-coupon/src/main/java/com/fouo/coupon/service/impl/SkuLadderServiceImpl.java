package com.fouo.coupon.service.impl;

import com.fouo.coupon.entity.SkuLadder;
import com.fouo.coupon.vo.SkuLadderVO;
import com.fouo.coupon.mapper.SkuLadderMapper;
import com.fouo.coupon.service.ISkuLadderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品阶梯价格 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class SkuLadderServiceImpl extends ServiceImpl<SkuLadderMapper, SkuLadder> implements ISkuLadderService {

	@Override
	public IPage<SkuLadderVO> selectSkuLadderPage(IPage<SkuLadderVO> page, SkuLadderVO skuLadder) {
		return page.setRecords(baseMapper.selectSkuLadderPage(page, skuLadder));
	}

}
