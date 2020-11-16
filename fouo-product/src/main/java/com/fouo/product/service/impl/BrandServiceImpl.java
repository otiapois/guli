package com.fouo.product.service.impl;

import com.fouo.product.entity.Brand;
import com.fouo.product.service.ICategoryBrandRelationService;
import com.fouo.product.vo.BrandVO;
import com.fouo.product.mapper.BrandMapper;
import com.fouo.product.service.IBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * 品牌 服务实现类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

	@Autowired
	private ICategoryBrandRelationService categoryBrandRelationService;

	@Override
	public IPage<BrandVO> selectBrandPage(IPage<BrandVO> page, BrandVO brand) {
		List<BrandVO> list = baseMapper.selectBrandPage(page, brand);
		//设置总条数
		page.setTotal(list.size());
		return page.setRecords(list);
	}

	@Override
	public boolean updateDetail(Brand brand) {
		//保证冗余字段的数据一致
		boolean flag = updateById(brand);
		if(StringUtils.isNotBlank(brand.getName())){
			//同步更新其他关联表中的数据
			categoryBrandRelationService.updateBrandNameByBrandId(brand.getBrandId(),brand.getName());
		}
		return flag;
	}
}
