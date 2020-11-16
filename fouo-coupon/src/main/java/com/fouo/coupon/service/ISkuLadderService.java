package com.fouo.coupon.service;

import com.fouo.coupon.entity.SkuLadder;
import com.fouo.coupon.vo.SkuLadderVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品阶梯价格 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface ISkuLadderService extends IService<SkuLadder> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param skuLadder
	 * @return
	 */
	IPage<SkuLadderVO> selectSkuLadderPage(IPage<SkuLadderVO> page, SkuLadderVO skuLadder);

}
