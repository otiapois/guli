package com.fouo.product.mapper;

import com.fouo.product.entity.AttrAttrgroupRelation;
import com.fouo.product.vo.AttrAttrgroupRelationVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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

}
