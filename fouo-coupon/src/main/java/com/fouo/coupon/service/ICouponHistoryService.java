package com.fouo.coupon.service;

import com.fouo.coupon.entity.CouponHistory;
import com.fouo.coupon.vo.CouponHistoryVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 优惠券领取历史记录 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface ICouponHistoryService extends IService<CouponHistory> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param couponHistory
	 * @return
	 */
	IPage<CouponHistoryVO> selectCouponHistoryPage(IPage<CouponHistoryVO> page, CouponHistoryVO couponHistory);

}
