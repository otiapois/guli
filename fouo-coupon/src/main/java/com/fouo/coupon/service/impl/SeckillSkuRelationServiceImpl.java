package com.fouo.coupon.service.impl;

import com.fouo.coupon.entity.SeckillSkuRelation;
import com.fouo.coupon.vo.SeckillSkuRelationVO;
import com.fouo.coupon.mapper.SeckillSkuRelationMapper;
import com.fouo.coupon.service.ISeckillSkuRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 秒杀活动商品关联 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class SeckillSkuRelationServiceImpl extends ServiceImpl<SeckillSkuRelationMapper, SeckillSkuRelation> implements ISeckillSkuRelationService {

	@Override
	public IPage<SeckillSkuRelationVO> selectSeckillSkuRelationPage(IPage<SeckillSkuRelationVO> page, SeckillSkuRelationVO seckillSkuRelation) {
		return page.setRecords(baseMapper.selectSeckillSkuRelationPage(page, seckillSkuRelation));
	}

}
