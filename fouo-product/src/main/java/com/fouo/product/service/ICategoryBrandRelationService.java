package com.fouo.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fouo.product.entity.Brand;
import com.fouo.product.entity.CategoryBrandRelation;
import com.fouo.product.vo.CategoryBrandRelationVO;

import java.util.List;

/**
 * 品牌&分类 服务类
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface ICategoryBrandRelationService extends IService<CategoryBrandRelation> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param categoryBrandRelation
	 * @return
	 */
	IPage<CategoryBrandRelationVO> selectCategoryBrandRelationPage(IPage<CategoryBrandRelationVO> page, CategoryBrandRelationVO categoryBrandRelation);

	/**
	 * 存储 商品分类 关系
	 * @param categoryBrandRelation
	 * @return
	 */
	boolean saveDetail(CategoryBrandRelation categoryBrandRelation);

	/**
	 *  根据商品id修改商品名称
	 * @param brandId
	 * @param name
	 * @return
	 */
    boolean updateBrandNameByBrandId(Long brandId, String name);

	/**
	 * 根据分类id修改分类名称
	 * @param catId
	 * @param name
	 */
	boolean updateCategoryNameByCategoryId(Long catId, String name);

	/**
	 * 根据分类id查询
	 * @param catId
	 * @return
	 */
	List<Brand> relationBrandsList(Long catId);
}
