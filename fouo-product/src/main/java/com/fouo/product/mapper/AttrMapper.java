package com.fouo.product.mapper;

import com.fouo.product.entity.Attr;
import com.fouo.product.vo.AttrVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 商品属性 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface AttrMapper extends BaseMapper<Attr> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param attr
	 * @return
	 */
	List<Attr> selectAttrPage(IPage page, AttrVO attr);

	/**
	 * 分页查询基本属性列表
	 * @param page
	 * @param attrVO
	 * @return
	 */
    List<Attr> selectBaseAttrPage(IPage page, AttrVO attrVO);

	/**
	 * 分页查询销售属性列表
	 * @param page
	 * @param attrVO
	 * @return
	 */
	List<Attr> selectSaleAttrPage(IPage<AttrVO> page, AttrVO attrVO);
}
