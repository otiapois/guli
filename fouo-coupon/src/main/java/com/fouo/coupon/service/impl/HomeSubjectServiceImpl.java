package com.fouo.coupon.service.impl;

import com.fouo.coupon.entity.HomeSubject;
import com.fouo.coupon.vo.HomeSubjectVO;
import com.fouo.coupon.mapper.HomeSubjectMapper;
import com.fouo.coupon.service.IHomeSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class HomeSubjectServiceImpl extends ServiceImpl<HomeSubjectMapper, HomeSubject> implements IHomeSubjectService {

	@Override
	public IPage<HomeSubjectVO> selectHomeSubjectPage(IPage<HomeSubjectVO> page, HomeSubjectVO homeSubject) {
		return page.setRecords(baseMapper.selectHomeSubjectPage(page, homeSubject));
	}

}
