package com.fouo.product.mapper;

import com.fouo.product.entity.AttrGroup;
import com.fouo.product.vo.AttrGroupVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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

}
