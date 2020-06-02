package com.fouo.product.service.impl;

import com.fouo.product.entity.SpuImages;
import com.fouo.product.vo.SpuImagesVO;
import com.fouo.product.mapper.SpuImagesMapper;
import com.fouo.product.service.ISpuImagesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * spu图片 服务实现类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Service
public class SpuImagesServiceImpl extends ServiceImpl<SpuImagesMapper, SpuImages> implements ISpuImagesService {

	@Override
	public IPage<SpuImagesVO> selectSpuImagesPage(IPage<SpuImagesVO> page, SpuImagesVO spuImages) {
		return page.setRecords(baseMapper.selectSpuImagesPage(page, spuImages));
	}

}
