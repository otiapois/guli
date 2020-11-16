package com.fouo.coupon.service;

import com.fouo.coupon.entity.SkuBounds;
import com.fouo.coupon.vo.SkuBoundsVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品sku积分设置 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface ISkuBoundsService extends IService<SkuBounds> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param skuBounds
	 * @return
	 */
	IPage<SkuBoundsVO> selectSkuBoundsPage(IPage<SkuBoundsVO> page, SkuBoundsVO skuBounds);

}
