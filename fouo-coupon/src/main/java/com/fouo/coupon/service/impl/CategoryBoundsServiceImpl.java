package com.fouo.coupon.service.impl;

import com.fouo.coupon.entity.CategoryBounds;
import com.fouo.coupon.vo.CategoryBoundsVO;
import com.fouo.coupon.mapper.CategoryBoundsMapper;
import com.fouo.coupon.service.ICategoryBoundsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品分类积分设置 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class CategoryBoundsServiceImpl extends ServiceImpl<CategoryBoundsMapper, CategoryBounds> implements ICategoryBoundsService {

	@Override
	public IPage<CategoryBoundsVO> selectCategoryBoundsPage(IPage<CategoryBoundsVO> page, CategoryBoundsVO categoryBounds) {
		return page.setRecords(baseMapper.selectCategoryBoundsPage(page, categoryBounds));
	}

}
