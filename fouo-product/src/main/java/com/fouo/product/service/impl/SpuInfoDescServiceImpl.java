package com.fouo.product.service.impl;

import com.fouo.product.entity.SpuInfoDesc;
import com.fouo.product.vo.SpuInfoDescVO;
import com.fouo.product.mapper.SpuInfoDescMapper;
import com.fouo.product.service.ISpuInfoDescService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * spu信息介绍 服务实现类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Service
public class SpuInfoDescServiceImpl extends ServiceImpl<SpuInfoDescMapper, SpuInfoDesc> implements ISpuInfoDescService {

	@Override
	public IPage<SpuInfoDescVO> selectSpuInfoDescPage(IPage<SpuInfoDescVO> page, SpuInfoDescVO spuInfoDesc) {
		return page.setRecords(baseMapper.selectSpuInfoDescPage(page, spuInfoDesc));
	}

}
