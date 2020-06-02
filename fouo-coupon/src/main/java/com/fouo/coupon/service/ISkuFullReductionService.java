package com.fouo.coupon.service;

import com.fouo.coupon.entity.SkuFullReduction;
import com.fouo.coupon.vo.SkuFullReductionVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品满减信息 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface ISkuFullReductionService extends IService<SkuFullReduction> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param skuFullReduction
	 * @return
	 */
	IPage<SkuFullReductionVO> selectSkuFullReductionPage(IPage<SkuFullReductionVO> page, SkuFullReductionVO skuFullReduction);

}
