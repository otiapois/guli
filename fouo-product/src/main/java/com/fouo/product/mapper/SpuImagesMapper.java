package com.fouo.product.mapper;

import com.fouo.product.entity.SpuImages;
import com.fouo.product.vo.SpuImagesVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * spu图片 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface SpuImagesMapper extends BaseMapper<SpuImages> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param spuImages
	 * @return
	 */
	List<SpuImagesVO> selectSpuImagesPage(IPage page, SpuImagesVO spuImages);

}
