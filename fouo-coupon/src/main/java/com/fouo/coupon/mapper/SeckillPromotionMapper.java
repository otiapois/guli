package com.fouo.coupon.mapper;

import com.fouo.coupon.entity.SeckillPromotion;
import com.fouo.coupon.vo.SeckillPromotionVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 秒杀活动 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface SeckillPromotionMapper extends BaseMapper<SeckillPromotion> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param seckillPromotion
	 * @return
	 */
	List<SeckillPromotionVO> selectSeckillPromotionPage(IPage page, SeckillPromotionVO seckillPromotion);

}
