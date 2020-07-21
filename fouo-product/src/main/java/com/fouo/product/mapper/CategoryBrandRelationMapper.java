package com.fouo.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.product.entity.CategoryBrandRelation;
import com.fouo.product.vo.CategoryBrandRelationVO;

import java.util.List;

/**
 * 品牌&分类关联 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-18
 */
public interface CategoryBrandRelationMapper extends BaseMapper<CategoryBrandRelation> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param categoryBrandRelation
	 * @return
	 */
	List<CategoryBrandRelationVO> selectCategoryBrandRelationPage(IPage page, CategoryBrandRelationVO categoryBrandRelation);

	/**
	 * 根据商品id修改商品名称
	 * @param brandId
	 * @param name
	 * @return
	 */
    boolean updateBrandNameByBrandId(Long brandId, String name);

	/**
	 * 根据分类id修改分类名称
	 * @param catId
	 * @param name
	 * @return
	 */
    boolean updateCategoryNameByCategoryId(Long catId, String name);

	/**
	 * 根据分类id获取
	 * @param catId
	 * @return
	 */
	List<Long> getBrandIdsByCatelogId(Long catId);
}
