package com.fouo.product.service;

import com.fouo.product.entity.AttrAttrgroupRelation;
import com.fouo.product.vo.AttrAttrgroupRelationVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

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

}
