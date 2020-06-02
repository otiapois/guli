package com.fouo.product.mapper;

import com.fouo.product.entity.SkuInfo;
import com.fouo.product.vo.SkuInfoVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * sku信息 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface SkuInfoMapper extends BaseMapper<SkuInfo> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param skuInfo
	 * @return
	 */
	List<SkuInfoVO> selectSkuInfoPage(IPage page, SkuInfoVO skuInfo);

}
