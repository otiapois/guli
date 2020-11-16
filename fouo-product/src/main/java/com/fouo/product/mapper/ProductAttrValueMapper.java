package com.fouo.product.mapper;

import com.fouo.product.entity.ProductAttrValue;
import com.fouo.product.vo.ProductAttrValueVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * spu属性值 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface ProductAttrValueMapper extends BaseMapper<ProductAttrValue> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param productAttrValue
	 * @return
	 */
	List<ProductAttrValueVO> selectProductAttrValuePage(IPage page, ProductAttrValueVO productAttrValue);

	/**
	 * 根据skuId获取相应参数
	 * @param skuId
	 * @return
	 */
    List<String> getSkuSaleAttrValues(Long skuId);
}
