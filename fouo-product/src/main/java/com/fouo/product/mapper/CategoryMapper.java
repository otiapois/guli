package com.fouo.product.mapper;

import com.fouo.product.entity.Category;
import com.fouo.product.vo.CategoryVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 商品三级分类 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface CategoryMapper extends BaseMapper<Category> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param category
	 * @return
	 */
	List<CategoryVO> selectCategoryPage(IPage page, CategoryVO category);

	/**
	 * 根据id获取分类名称
	 * @param catelogId 分类id
	 * @return
	 */
    String getCatelogNameById(Long catelogId);
}
