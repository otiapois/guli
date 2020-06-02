package com.fouo.product.service.impl;

import com.fouo.product.entity.Brand;
import com.fouo.product.vo.BrandVO;
import com.fouo.product.mapper.BrandMapper;
import com.fouo.product.service.IBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 品牌 服务实现类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

	@Override
	public IPage<BrandVO> selectBrandPage(IPage<BrandVO> page, BrandVO brand) {
		return page.setRecords(baseMapper.selectBrandPage(page, brand));
	}

}
