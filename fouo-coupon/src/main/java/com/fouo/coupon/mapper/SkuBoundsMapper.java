package com.fouo.coupon.mapper;

import com.fouo.coupon.entity.SkuBounds;
import com.fouo.coupon.vo.SkuBoundsVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 商品sku积分设置 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface SkuBoundsMapper extends BaseMapper<SkuBounds> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param skuBounds
	 * @return
	 */
	List<SkuBoundsVO> selectSkuBoundsPage(IPage page, SkuBoundsVO skuBounds);

}
