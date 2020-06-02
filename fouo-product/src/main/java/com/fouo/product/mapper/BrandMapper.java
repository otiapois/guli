package com.fouo.product.mapper;

import com.fouo.product.entity.Brand;
import com.fouo.product.vo.BrandVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 品牌 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface BrandMapper extends BaseMapper<Brand> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param brand
	 * @return
	 */
	List<BrandVO> selectBrandPage(IPage page, BrandVO brand);

}
