package com.fouo.coupon.service.impl;

import com.fouo.coupon.entity.HomeSubjectSpu;
import com.fouo.coupon.vo.HomeSubjectSpuVO;
import com.fouo.coupon.mapper.HomeSubjectSpuMapper;
import com.fouo.coupon.service.IHomeSubjectSpuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 专题商品 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class HomeSubjectSpuServiceImpl extends ServiceImpl<HomeSubjectSpuMapper, HomeSubjectSpu> implements IHomeSubjectSpuService {

	@Override
	public IPage<HomeSubjectSpuVO> selectHomeSubjectSpuPage(IPage<HomeSubjectSpuVO> page, HomeSubjectSpuVO homeSubjectSpu) {
		return page.setRecords(baseMapper.selectHomeSubjectSpuPage(page, homeSubjectSpu));
	}

}
