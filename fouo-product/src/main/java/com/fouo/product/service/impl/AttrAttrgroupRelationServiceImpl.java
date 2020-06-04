package com.fouo.product.service.impl;

import com.fouo.product.entity.AttrAttrgroupRelation;
import com.fouo.product.vo.AttrAttrgroupRelationVO;
import com.fouo.product.mapper.AttrAttrgroupRelationMapper;
import com.fouo.product.service.IAttrAttrgroupRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;

/**
 * 属性&属性分组关联 服务实现类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Service
public class AttrAttrgroupRelationServiceImpl extends ServiceImpl<AttrAttrgroupRelationMapper, AttrAttrgroupRelation> implements IAttrAttrgroupRelationService {

	@Override
	public IPage<AttrAttrgroupRelationVO> selectAttrAttrgroupRelationPage(IPage<AttrAttrgroupRelationVO> page, AttrAttrgroupRelationVO attrAttrgroupRelation) {
		return page.setRecords(baseMapper.selectAttrAttrgroupRelationPage(page, attrAttrgroupRelation));
	}

}
