package com.fouo.product.mapper;

import com.fouo.product.entity.SkuImages;
import com.fouo.product.vo.SkuImagesVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * sku图片 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface SkuImagesMapper extends BaseMapper<SkuImages> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param skuImages
	 * @return
	 */
	List<SkuImagesVO> selectSkuImagesPage(IPage page, SkuImagesVO skuImages);

}
