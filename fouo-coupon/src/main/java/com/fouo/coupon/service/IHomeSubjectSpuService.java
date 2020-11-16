package com.fouo.coupon.service;

import com.fouo.coupon.entity.HomeSubjectSpu;
import com.fouo.coupon.vo.HomeSubjectSpuVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 专题商品 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IHomeSubjectSpuService extends IService<HomeSubjectSpu> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param homeSubjectSpu
	 * @return
	 */
	IPage<HomeSubjectSpuVO> selectHomeSubjectSpuPage(IPage<HomeSubjectSpuVO> page, HomeSubjectSpuVO homeSubjectSpu);

}
