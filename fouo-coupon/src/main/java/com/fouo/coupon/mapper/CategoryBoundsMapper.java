package com.fouo.coupon.mapper;

import com.fouo.coupon.entity.CategoryBounds;
import com.fouo.coupon.vo.CategoryBoundsVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 商品分类积分设置 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface CategoryBoundsMapper extends BaseMapper<CategoryBounds> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param categoryBounds
	 * @return
	 */
	List<CategoryBoundsVO> selectCategoryBoundsPage(IPage page, CategoryBoundsVO categoryBounds);

}
