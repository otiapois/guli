package com.fouo.coupon.service;

import com.fouo.coupon.entity.MemberPrice;
import com.fouo.coupon.vo.MemberPriceVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品会员价格 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IMemberPriceService extends IService<MemberPrice> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param memberPrice
	 * @return
	 */
	IPage<MemberPriceVO> selectMemberPricePage(IPage<MemberPriceVO> page, MemberPriceVO memberPrice);

}
