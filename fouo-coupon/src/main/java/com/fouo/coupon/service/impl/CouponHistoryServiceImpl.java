package com.fouo.coupon.service.impl;

import com.fouo.coupon.entity.CouponHistory;
import com.fouo.coupon.vo.CouponHistoryVO;
import com.fouo.coupon.mapper.CouponHistoryMapper;
import com.fouo.coupon.service.ICouponHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 优惠券领取历史记录 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class CouponHistoryServiceImpl extends ServiceImpl<CouponHistoryMapper, CouponHistory> implements ICouponHistoryService {

	@Override
	public IPage<CouponHistoryVO> selectCouponHistoryPage(IPage<CouponHistoryVO> page, CouponHistoryVO couponHistory) {
		return page.setRecords(baseMapper.selectCouponHistoryPage(page, couponHistory));
	}

}
