package com.fouo.product.service.impl;

import com.fouo.product.entity.Category;
import com.fouo.product.vo.CategoryVO;
import com.fouo.product.mapper.CategoryMapper;
import com.fouo.product.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品三级分类 服务实现类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

	@Override
	public IPage<CategoryVO> selectCategoryPage(IPage<CategoryVO> page, CategoryVO category) {
		return page.setRecords(baseMapper.selectCategoryPage(page, category));
	}

}
