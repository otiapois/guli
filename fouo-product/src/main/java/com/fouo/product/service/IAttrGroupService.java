package com.fouo.product.service;

import com.fouo.product.entity.AttrGroup;
import com.fouo.product.vo.AttrGroupVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

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

}
