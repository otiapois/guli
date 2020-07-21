package com.fouo.product.service;

import com.fouo.common.support.Query;
import com.fouo.product.entity.Category;
import com.fouo.product.vo.CategoryVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

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

	/**
	 * 查询商品列表
	 * 并设置商品列表的子分类
	 * @param category
	 * @param query
	 * @return
	 */
    IPage<Category> listWithTree(Category category, Query query);

	/**
	 * 批量删除三级菜单
	 * @param ids
	 * @return
	 */
	boolean removeMenu(List<Long> ids);

	/**
	 * 根据categoryId 获取完整路径
	 * @param catelogId
	 * @return
	 */
    Long[] searchCatelogPath(Long catelogId);

	/**
	 * 更新分类
	 * @param category
	 * @return
	 */
	boolean updateDetail(Category category);
}
