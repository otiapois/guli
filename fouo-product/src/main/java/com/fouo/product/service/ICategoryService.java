package com.fouo.product.service;

import com.fouo.product.entity.Category;
import com.fouo.product.vo.CategoryVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品三级分类 服务类
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface ICategoryService extends IService<Category> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param category
	 * @return
	 */
	IPage<CategoryVO> selectCategoryPage(IPage<CategoryVO> page, CategoryVO category);

}
