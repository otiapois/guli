package com.fouo.coupon.service;

import com.fouo.coupon.entity.SeckillPromotion;
import com.fouo.coupon.vo.SeckillPromotionVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 秒杀活动 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface ISeckillPromotionService extends IService<SeckillPromotion> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param seckillPromotion
	 * @return
	 */
	IPage<SeckillPromotionVO> selectSeckillPromotionPage(IPage<SeckillPromotionVO> page, SeckillPromotionVO seckillPromotion);

}
