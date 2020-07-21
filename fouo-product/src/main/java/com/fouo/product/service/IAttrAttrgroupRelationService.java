package com.fouo.product.service;

import com.fouo.product.entity.AttrAttrgroupRelation;
import com.fouo.product.vo.AttrAttrgroupRelationVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.product.vo.AttrGroupVO;

import java.util.List;

/**
 * 属性&属性分组关联 服务类
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface IAttrAttrgroupRelationService extends IService<AttrAttrgroupRelation> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param attrAttrgroupRelation
	 * @return
	 */
	IPage<AttrAttrgroupRelationVO> selectAttrAttrgroupRelationPage(IPage<AttrAttrgroupRelationVO> page, AttrAttrgroupRelationVO attrAttrgroupRelation);

	/**
	 * 移除属性和其分组的关联关系
	 * @param attrId 属性id
	 * @param attrGroupId 属性分组id
	 * @return
	 */
    boolean removeRelation(Long attrId, Long attrGroupId);

	/**
	 * 批量删除关联关系
	 * @param list
	 * @return
	 */
	boolean removeRelationBatch(List<AttrGroupVO> list);

	/**
	 *
	 * @param list
	 * @return
	 */
    boolean addRelationBatch(List<AttrAttrgroupRelationVO> list);
}
