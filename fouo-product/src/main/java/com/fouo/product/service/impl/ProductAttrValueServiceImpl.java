package com.fouo.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fouo.product.entity.ProductAttrValue;
import com.fouo.product.vo.ProductAttrValueVO;
import com.fouo.product.mapper.ProductAttrValueMapper;
import com.fouo.product.service.IProductAttrValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public List<ProductAttrValue> getSpuList(Long spuId) {
		return baseMapper.selectList(new QueryWrapper<ProductAttrValue>().eq("spu_id", spuId));
	}

	@Transactional
	@Override
	public boolean updateSpuAttr(Long spuId, List<ProductAttrValue> entities) {
		//删除这个spuId之前对应的所有属性
		this.baseMapper.delete(new QueryWrapper<ProductAttrValue>().eq("spu_id", spuId));

		List<ProductAttrValue> collect = entities.stream().map(item -> {
			item.setSpuId(spuId);
			return item;
		}).collect(Collectors.toList());
		return saveBatch(collect);
	}
}
