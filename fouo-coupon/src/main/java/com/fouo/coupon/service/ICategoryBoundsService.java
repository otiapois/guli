package com.fouo.coupon.service;

import com.fouo.coupon.entity.CategoryBounds;
import com.fouo.coupon.vo.CategoryBoundsVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品分类积分设置 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface ICategoryBoundsService extends IService<CategoryBounds> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param categoryBounds
	 * @return
	 */
	IPage<CategoryBoundsVO> selectCategoryBoundsPage(IPage<CategoryBoundsVO> page, CategoryBoundsVO categoryBounds);

}
