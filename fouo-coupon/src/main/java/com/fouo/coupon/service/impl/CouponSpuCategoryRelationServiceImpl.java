package com.fouo.coupon.service.impl;

import com.fouo.coupon.entity.CouponSpuCategoryRelation;
import com.fouo.coupon.vo.CouponSpuCategoryRelationVO;
import com.fouo.coupon.mapper.CouponSpuCategoryRelationMapper;
import com.fouo.coupon.service.ICouponSpuCategoryRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 优惠券分类关联 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class CouponSpuCategoryRelationServiceImpl extends ServiceImpl<CouponSpuCategoryRelationMapper, CouponSpuCategoryRelation> implements ICouponSpuCategoryRelationService {

	@Override
	public IPage<CouponSpuCategoryRelationVO> selectCouponSpuCategoryRelationPage(IPage<CouponSpuCategoryRelationVO> page, CouponSpuCategoryRelationVO couponSpuCategoryRelation) {
		return page.setRecords(baseMapper.selectCouponSpuCategoryRelationPage(page, couponSpuCategoryRelation));
	}

}
