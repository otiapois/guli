package com.fouo.product.mapper;

import com.fouo.product.entity.AttrGroup;
import com.fouo.product.vo.AttrGroupVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.product.vo.ext.SpuItemAttrGroupVO;

import java.util.List;

/**
 * 属性分组 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface AttrGroupMapper extends BaseMapper<AttrGroup> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param attrGroup
	 * @return
	 */
	List<AttrGroupVO> selectAttrGroupPage(IPage page, AttrGroupVO attrGroup);

	/**
	 * 根据分组id获取分组名称
	 * @param groupId 分组id
	 * @return
	 */
    String getGroupNameById(Long groupId);

	/**
	 * 查询当前spu对应的所有属性的分组信息
	 * 当前分组下所有属性对应的值
	 * @param spuId
	 * @param catalogId
	 * @return
	 */
	List<SpuItemAttrGroupVO> getAttrGroupWithAttrsBySpuId(Long spuId, Long catalogId);
}
