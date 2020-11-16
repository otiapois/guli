package com.fouo.coupon.service.impl;

import com.fouo.coupon.entity.SeckillPromotion;
import com.fouo.coupon.vo.SeckillPromotionVO;
import com.fouo.coupon.mapper.SeckillPromotionMapper;
import com.fouo.coupon.service.ISeckillPromotionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 秒杀活动 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class SeckillPromotionServiceImpl extends ServiceImpl<SeckillPromotionMapper, SeckillPromotion> implements ISeckillPromotionService {

	@Override
	public IPage<SeckillPromotionVO> selectSeckillPromotionPage(IPage<SeckillPromotionVO> page, SeckillPromotionVO seckillPromotion) {
		return page.setRecords(baseMapper.selectSeckillPromotionPage(page, seckillPromotion));
	}

}
