package com.fouo.product.service;

import com.fouo.product.entity.Attr;
import com.fouo.product.vo.AttrVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品属性 服务类
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface IAttrService extends IService<Attr> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param attr
	 * @return
	 */
	IPage<AttrVO> selectAttrPage(IPage<AttrVO> page, AttrVO attr);

}
