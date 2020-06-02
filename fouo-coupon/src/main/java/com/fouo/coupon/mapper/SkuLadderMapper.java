package com.fouo.coupon.mapper;

import com.fouo.coupon.entity.SkuLadder;
import com.fouo.coupon.vo.SkuLadderVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 商品阶梯价格 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface SkuLadderMapper extends BaseMapper<SkuLadder> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param skuLadder
	 * @return
	 */
	List<SkuLadderVO> selectSkuLadderPage(IPage page, SkuLadderVO skuLadder);

}
