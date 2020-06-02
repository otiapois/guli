package com.fouo.coupon.mapper;

import com.fouo.coupon.entity.SpuBounds;
import com.fouo.coupon.vo.SpuBoundsVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 商品spu积分设置 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface SpuBoundsMapper extends BaseMapper<SpuBounds> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param spuBounds
	 * @return
	 */
	List<SpuBoundsVO> selectSpuBoundsPage(IPage page, SpuBoundsVO spuBounds);

}
