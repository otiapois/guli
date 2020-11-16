package com.fouo.product.mapper;

import com.fouo.product.entity.SpuInfo;
import com.fouo.product.vo.SpuInfoVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * spu信息 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface SpuInfoMapper extends BaseMapper<SpuInfo> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param spuInfo
	 * @return
	 */
	List<SpuInfoVO> selectSpuInfoPage(IPage page, SpuInfoVO spuInfo);

    void updateSpuStatus(Long spuId, int code);
}
