package com.fouo.coupon.service;

import com.fouo.coupon.entity.HomeAdv;
import com.fouo.coupon.vo.HomeAdvVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 首页轮播广告 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IHomeAdvService extends IService<HomeAdv> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param homeAdv
	 * @return
	 */
	IPage<HomeAdvVO> selectHomeAdvPage(IPage<HomeAdvVO> page, HomeAdvVO homeAdv);

}
