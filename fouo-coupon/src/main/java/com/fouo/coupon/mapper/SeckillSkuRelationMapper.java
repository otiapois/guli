package com.fouo.coupon.mapper;

import com.fouo.coupon.entity.SeckillSkuRelation;
import com.fouo.coupon.vo.SeckillSkuRelationVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 秒杀活动商品关联 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface SeckillSkuRelationMapper extends BaseMapper<SeckillSkuRelation> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param seckillSkuRelation
	 * @return
	 */
	List<SeckillSkuRelationVO> selectSeckillSkuRelationPage(IPage page, SeckillSkuRelationVO seckillSkuRelation);

}
