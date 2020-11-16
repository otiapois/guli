package com.fouo.product.mapper;

import com.fouo.product.entity.SpuInfoDesc;
import com.fouo.product.vo.SpuInfoDescVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * spu信息介绍 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface SpuInfoDescMapper extends BaseMapper<SpuInfoDesc> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param spuInfoDesc
	 * @return
	 */
	List<SpuInfoDescVO> selectSpuInfoDescPage(IPage page, SpuInfoDescVO spuInfoDesc);

}
