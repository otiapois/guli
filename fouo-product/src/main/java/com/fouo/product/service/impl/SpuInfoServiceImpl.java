package com.fouo.product.service.impl;

import com.fouo.product.entity.SpuInfo;
import com.fouo.product.vo.SpuInfoVO;
import com.fouo.product.mapper.SpuInfoMapper;
import com.fouo.product.service.ISpuInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * spu信息 服务实现类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Service
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoMapper, SpuInfo> implements ISpuInfoService {

	@Override
	public IPage<SpuInfoVO> selectSpuInfoPage(IPage<SpuInfoVO> page, SpuInfoVO spuInfo) {
		return page.setRecords(baseMapper.selectSpuInfoPage(page, spuInfo));
	}

}
