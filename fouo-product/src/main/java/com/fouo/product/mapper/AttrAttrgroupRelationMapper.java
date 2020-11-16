package com.fouo.product.mapper;

import com.fouo.product.entity.AttrAttrgroupRelation;
import com.fouo.product.vo.AttrAttrgroupRelationVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.product.vo.AttrGroupVO;

import java.util.List;

/**
 * 属性&属性分组关联 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface AttrAttrgroupRelationMapper extends BaseMapper<AttrAttrgroupRelation> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param attrAttrgroupRelation
	 * @return
	 */
	List<AttrAttrgroupRelationVO> selectAttrAttrgroupRelationPage(IPage page, AttrAttrgroupRelationVO attrAttrgroupRelation);

	/**
	 * 根据属性id查询属性分组id
	 * @param attrId
	 * @return
	 */
	Long getGroupIdByAttrId(Long attrId);

	/**
	 * 根据分组id获取相对应的所有基本属性id
	 * @param attrGroupId
	 * @return
	 */
	List<Long> getAttrIdsByGroupId(Long attrGroupId);

	/**
	 * 移除属性及其分组的关联关系
	 * @param attrId
	 * @param attrGroupId
	 * @return
	 */
	boolean removeRelation(Long attrId, Long attrGroupId);

	/**
	 * 批量删除关联关系
	 * @param list
	 * @return
	 */
	boolean removeRelationBatch(List<AttrGroupVO> list);
}
