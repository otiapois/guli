package com.fouo.product.service;

import com.fouo.product.entity.SpuImages;
import com.fouo.product.vo.SpuImagesVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * spu图片 服务类
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface ISpuImagesService extends IService<SpuImages> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param spuImages
	 * @return
	 */
	IPage<SpuImagesVO> selectSpuImagesPage(IPage<SpuImagesVO> page, SpuImagesVO spuImages);

	/**
	 * 保存图片
	 * @param id
	 * @param images
	 * @return
	 */
    boolean saveImages(Long id, List<String> images);
}
