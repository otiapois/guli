package com.fouo.coupon.service.impl;

import com.fouo.coupon.entity.CouponSpuRelation;
import com.fouo.coupon.vo.CouponSpuRelationVO;
import com.fouo.coupon.mapper.CouponSpuRelationMapper;
import com.fouo.coupon.service.ICouponSpuRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 优惠券与产品关联 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class CouponSpuRelationServiceImpl extends ServiceImpl<CouponSpuRelationMapper, CouponSpuRelation> implements ICouponSpuRelationService {

	@Override
	public IPage<CouponSpuRelationVO> selectCouponSpuRelationPage(IPage<CouponSpuRelationVO> page, CouponSpuRelationVO couponSpuRelation) {
		return page.setRecords(baseMapper.selectCouponSpuRelationPage(page, couponSpuRelation));
	}

}
