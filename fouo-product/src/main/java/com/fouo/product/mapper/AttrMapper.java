package com.fouo.product.mapper;

import com.fouo.product.entity.Attr;
import com.fouo.product.vo.AttrVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 商品属性 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface AttrMapper extends BaseMapper<Attr> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param attr
	 * @return
	 */
	List<AttrVO> selectAttrPage(IPage page, AttrVO attr);

}
