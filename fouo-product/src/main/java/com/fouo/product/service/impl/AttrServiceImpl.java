package com.fouo.product.service.impl;

import com.fouo.product.entity.Attr;
import com.fouo.product.vo.AttrVO;
import com.fouo.product.mapper.AttrMapper;
import com.fouo.product.service.IAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品属性 服务实现类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Service
public class AttrServiceImpl extends ServiceImpl<AttrMapper, Attr> implements IAttrService {

	@Override
	public IPage<AttrVO> selectAttrPage(IPage<AttrVO> page, AttrVO attr) {
		return page.setRecords(baseMapper.selectAttrPage(page, attr));
	}

}
