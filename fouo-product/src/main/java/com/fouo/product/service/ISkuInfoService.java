package com.fouo.product.service;

import com.fouo.product.entity.SkuInfo;
import com.fouo.product.vo.SkuInfoVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * sku信息 服务类
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface ISkuInfoService extends IService<SkuInfo> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param skuInfo
	 * @return
	 */
	IPage<SkuInfoVO> selectSkuInfoPage(IPage<SkuInfoVO> page, SkuInfoVO skuInfo);

}
