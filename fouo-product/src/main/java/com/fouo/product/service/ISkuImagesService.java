package com.fouo.product.service;

import com.fouo.product.entity.SkuImages;
import com.fouo.product.vo.SkuImagesVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * sku图片 服务类
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface ISkuImagesService extends IService<SkuImages> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param skuImages
	 * @return
	 */
	IPage<SkuImagesVO> selectSkuImagesPage(IPage<SkuImagesVO> page, SkuImagesVO skuImages);

	/**
	 * 根据skuId获取对应图片
	 * @param skuId
	 * @return
	 */
    List<SkuImages> getImagesBySkuId(Long skuId);
}
