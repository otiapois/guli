package com.fouo.product.service;

import com.fouo.product.entity.Brand;
import com.fouo.product.vo.BrandVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 品牌 服务类
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface IBrandService extends IService<Brand> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param brand
	 * @return
	 */
	IPage<BrandVO> selectBrandPage(IPage<BrandVO> page, BrandVO brand);

	/**
	 * 更新品牌
	 * @param brand
	 * @return
	 */
    boolean updateDetail(Brand brand);
}
