package com.fouo.coupon.mapper;

import com.fouo.coupon.entity.SkuFullReduction;
import com.fouo.coupon.vo.SkuFullReductionVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 商品满减信息 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface SkuFullReductionMapper extends BaseMapper<SkuFullReduction> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param skuFullReduction
	 * @return
	 */
	List<SkuFullReductionVO> selectSkuFullReductionPage(IPage page, SkuFullReductionVO skuFullReduction);

}
