package com.fouo.coupon.service.impl;

import com.fouo.coupon.entity.HomeAdv;
import com.fouo.coupon.vo.HomeAdvVO;
import com.fouo.coupon.mapper.HomeAdvMapper;
import com.fouo.coupon.service.IHomeAdvService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 首页轮播广告 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class HomeAdvServiceImpl extends ServiceImpl<HomeAdvMapper, HomeAdv> implements IHomeAdvService {

	@Override
	public IPage<HomeAdvVO> selectHomeAdvPage(IPage<HomeAdvVO> page, HomeAdvVO homeAdv) {
		return page.setRecords(baseMapper.selectHomeAdvPage(page, homeAdv));
	}

}
