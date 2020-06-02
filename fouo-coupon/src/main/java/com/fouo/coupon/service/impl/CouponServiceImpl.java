package com.fouo.coupon.service.impl;

import com.fouo.coupon.entity.Coupon;
import com.fouo.coupon.vo.CouponVO;
import com.fouo.coupon.mapper.CouponMapper;
import com.fouo.coupon.service.ICouponService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 优惠券信息 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements ICouponService {

	@Override
	public IPage<CouponVO> selectCouponPage(IPage<CouponVO> page, CouponVO coupon) {
		return page.setRecords(baseMapper.selectCouponPage(page, coupon));
	}

}
