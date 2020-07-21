package com.fouo.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fouo.product.entity.Brand;
import com.fouo.product.entity.Category;
import com.fouo.product.entity.CategoryBrandRelation;
import com.fouo.product.mapper.BrandMapper;
import com.fouo.product.mapper.CategoryBrandRelationMapper;
import com.fouo.product.mapper.CategoryMapper;
import com.fouo.product.service.ICategoryBrandRelationService;
import com.fouo.product.vo.CategoryBrandRelationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 品牌和分类关联 服务实现类
 *
 * @author fouo
 * @since 2020-06-18
 */
@Service
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationMapper, CategoryBrandRelation> implements ICategoryBrandRelationService {

	@Autowired
	private BrandMapper brandMapper;
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public IPage<CategoryBrandRelationVO> selectCategoryBrandRelationPage(IPage<CategoryBrandRelationVO> page, CategoryBrandRelationVO categoryBrandRelation) {
		return page.setRecords(baseMapper.selectCategoryBrandRelationPage(page, categoryBrandRelation));
	}

	@Override
	public boolean saveDetail(CategoryBrandRelation categoryBrandRelation) {
		//获取品牌id
		Long brandId = categoryBrandRelation.getBrandId();
		//获取分类id
		Long catelogId = categoryBrandRelation.getCatelogId();

		Brand brand = brandMapper.selectById(brandId);
		Category category = categoryMapper.selectById(catelogId);
		//设置品牌名称
		categoryBrandRelation.setBrandName(brand.getName());
		//设置分类名称
		categoryBrandRelation.setCatelogName(category.getName());

		return save(categoryBrandRelation);
	}

	@Override
	public boolean updateBrandNameByBrandId(Long brandId, String name) {
		return baseMapper.updateBrandNameByBrandId(brandId,name);
	}

	@Override
	public boolean updateCategoryNameByCategoryId(Long catId, String name) {
		return baseMapper.updateCategoryNameByCategoryId(catId,name);
	}

	@Override
	public List<Brand> relationBrandsList(Long catId) {
		List<Brand> brands = null;
		//根据分类id获取商品id
		List<Long> brandIds = baseMapper.getBrandIdsByCatelogId(catId);
		if(brandIds!=null && brandIds.size()>0){
			//根据商品id批量查询商品
			brands = brandMapper.selectBatchIds(brandIds);
		}
		return brands;
	}
}
