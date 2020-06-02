package com.fouo.product.service.impl;

import com.fouo.product.entity.ProductAttrValue;
import com.fouo.product.vo.ProductAttrValueVO;
import com.fouo.product.mapper.ProductAttrValueMapper;
import com.fouo.product.service.IProductAttrValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * spu属性值 服务实现类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Service
public class ProductAttrValueServiceImpl extends ServiceImpl<ProductAttrValueMapper, ProductAttrValue> implements IProductAttrValueService {

	@Override
	public IPage<ProductAttrValueVO> selectProductAttrValuePage(IPage<ProductAttrValueVO> page, ProductAttrValueVO productAttrValue) {
		return page.setRecords(baseMapper.selectProductAttrValuePage(page, productAttrValue));
	}

}
