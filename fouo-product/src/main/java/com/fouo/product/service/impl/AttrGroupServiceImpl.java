package com.fouo.product.service.impl;

import com.fouo.product.entity.AttrGroup;
import com.fouo.product.vo.AttrGroupVO;
import com.fouo.product.mapper.AttrGroupMapper;
import com.fouo.product.service.IAttrGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 属性分组 服务实现类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Service
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroup> implements IAttrGroupService {

	@Override
	public IPage<AttrGroupVO> selectAttrGroupPage(IPage<AttrGroupVO> page, AttrGroupVO attrGroup) {
		return page.setRecords(baseMapper.selectAttrGroupPage(page, attrGroup));
	}

}
