package com.fouo.product.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fouo.product.entity.ProductAttrValue;
import com.fouo.product.vo.ProductAttrValueVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

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

	/**
	 * 根据spuId获取SPU参数列表
	 * @param spuId
	 * @return
	 */
    List<ProductAttrValue> getSpuList(Long spuId);
	/**
	 * 根据spuid 批量修改属性
	 * @param spuId
	 * @param entities
	 * @return
	 */
	boolean updateSpuAttr(Long spuId, List<ProductAttrValue> entities);

	/**
	 * 根据skuId获取对应参数
	 * @param skuId
	 * @return
	 */
    List<String> getSkuSaleAttrValues(Long skuId);
}
