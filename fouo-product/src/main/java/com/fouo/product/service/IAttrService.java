package com.fouo.product.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fouo.product.entity.Attr;
import com.fouo.product.entity.ProductAttrValue;
import com.fouo.product.vo.AttrVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * 商品属性 服务类
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface IAttrService extends IService<Attr> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param attr
	 * @return
	 */
	IPage<AttrVO> selectAttrPage(IPage<AttrVO> page, AttrVO attr);

	/**
	 * 保存属性
	 * @param attrVO
	 * @return
	 */
    boolean saveAttr(AttrVO attrVO);

	/**
	 * 分页查询商品基本属性列表
	 * @param page
	 * @param attrVO
	 * @return
	 */
	IPage<AttrVO> selectBaseAttrPage(IPage<AttrVO> page, AttrVO attrVO);
	/**
	 * 分页查询商品销售属性列表
	 * @param page
	 * @param attrVO
	 * @return
	 */
	IPage<AttrVO> selectSaleAttrPage(IPage<AttrVO> page, AttrVO attrVO);
	/**
	 * 根据属性id查询详情信息
	 * @param attrId
	 * @return
	 */
	AttrVO getDetail(Long attrId);

	/**
	 * 修改属性信息
	 * @param attrVO
	 * @return
	 */
	boolean updateAttr(AttrVO attrVO);

	/**
	 * 根据分组id查找关联的所有基本属性
	 * @param attrGroupId
	 * @return
	 */
	List<Attr> getRelationAttr(Long attrGroupId);

	/**
	 * 在指定的所有属性集合中，挑出检索属性
	 * @param attrIds
	 * @return
	 */
	List<Long> selectSearchAttrs(List<Long> attrIds);
}
