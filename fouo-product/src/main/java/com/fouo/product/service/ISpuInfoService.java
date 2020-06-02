package com.fouo.product.service;

import com.fouo.product.entity.SpuInfo;
import com.fouo.product.vo.SpuInfoVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * spu信息 服务类
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface ISpuInfoService extends IService<SpuInfo> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param spuInfo
	 * @return
	 */
	IPage<SpuInfoVO> selectSpuInfoPage(IPage<SpuInfoVO> page, SpuInfoVO spuInfo);

}
