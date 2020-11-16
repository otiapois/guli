package com.fouo.coupon.service;

import com.fouo.coupon.entity.HomeSubject;
import com.fouo.coupon.vo.HomeSubjectVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IHomeSubjectService extends IService<HomeSubject> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param homeSubject
	 * @return
	 */
	IPage<HomeSubjectVO> selectHomeSubjectPage(IPage<HomeSubjectVO> page, HomeSubjectVO homeSubject);

}
