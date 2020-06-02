package com.fouo.product.service;

import com.fouo.product.entity.SpuInfoDesc;
import com.fouo.product.vo.SpuInfoDescVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * spu信息介绍 服务类
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface ISpuInfoDescService extends IService<SpuInfoDesc> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param spuInfoDesc
	 * @return
	 */
	IPage<SpuInfoDescVO> selectSpuInfoDescPage(IPage<SpuInfoDescVO> page, SpuInfoDescVO spuInfoDesc);

}
