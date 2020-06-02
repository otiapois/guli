package com.fouo.coupon.service;

import com.fouo.coupon.entity.SeckillSkuRelation;
import com.fouo.coupon.vo.SeckillSkuRelationVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 秒杀活动商品关联 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface ISeckillSkuRelationService extends IService<SeckillSkuRelation> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param seckillSkuRelation
	 * @return
	 */
	IPage<SeckillSkuRelationVO> selectSeckillSkuRelationPage(IPage<SeckillSkuRelationVO> page, SeckillSkuRelationVO seckillSkuRelation);

}
