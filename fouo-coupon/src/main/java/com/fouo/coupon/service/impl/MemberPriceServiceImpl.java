package com.fouo.coupon.service.impl;

import com.fouo.coupon.entity.MemberPrice;
import com.fouo.coupon.vo.MemberPriceVO;
import com.fouo.coupon.mapper.MemberPriceMapper;
import com.fouo.coupon.service.IMemberPriceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品会员价格 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class MemberPriceServiceImpl extends ServiceImpl<MemberPriceMapper, MemberPrice> implements IMemberPriceService {

	@Override
	public IPage<MemberPriceVO> selectMemberPricePage(IPage<MemberPriceVO> page, MemberPriceVO memberPrice) {
		return page.setRecords(baseMapper.selectMemberPricePage(page, memberPrice));
	}

}
