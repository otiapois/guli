package com.fouo.product.service;

import com.fouo.product.entity.ProductAttrValue;
import com.fouo.product.vo.ProductAttrValueVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * spu属性值 服务类
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface IProductAttrValueService extends IService<ProductAttrValue> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param productAttrValue
	 * @return
	 */
	IPage<ProductAttrValueVO> selectProductAttrValuePage(IPage<ProductAttrValueVO> page, ProductAttrValueVO productAttrValue);

}
