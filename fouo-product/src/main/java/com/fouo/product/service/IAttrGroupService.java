package com.fouo.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fouo.product.entity.Attr;
import com.fouo.product.entity.AttrGroup;
import com.fouo.product.vo.AttrGroupVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.product.vo.ext.SpuItemAttrGroupVO;

import java.util.List;

/**
 * 属性分组 服务类
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface IAttrGroupService extends IService<AttrGroup> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param attrGroup
	 * @return
	 */
	IPage<AttrGroupVO> selectAttrGroupPage(IPage<AttrGroupVO> page, AttrGroupVO attrGroup);

	/**
	 * 获取没有被关联的属性列表
	 * @param page
	 * @return
	 */
    IPage<Attr> selectNotRelation(IPage<Attr> page, AttrGroupVO attrGroupVO);

	/**
	 * 根据分类id查询该分类下所有分组及分组下所有属性
	 * @param catalogId
	 * @return
	 */
	List<AttrGroupVO> getAttrGroupWithAttrs(Long catalogId);

	/**
	 * 根据SpuId查询
	 * @param spuId
	 * @return
	 */
    List<SpuItemAttrGroupVO> getAttrGroupWithAttrsBySpuId(Long spuId,Long catelogId);
}
