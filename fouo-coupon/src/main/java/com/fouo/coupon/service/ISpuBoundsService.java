package com.fouo.coupon.service;

import com.fouo.coupon.entity.SpuBounds;
import com.fouo.coupon.vo.SpuBoundsVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品spu积分设置 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface ISpuBoundsService extends IService<SpuBounds> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param spuBounds
	 * @return
	 */
	IPage<SpuBoundsVO> selectSpuBoundsPage(IPage<SpuBoundsVO> page, SpuBoundsVO spuBounds);

}
