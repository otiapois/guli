package com.fouo.coupon.mapper;

import com.fouo.coupon.entity.CouponSpuRelation;
import com.fouo.coupon.vo.CouponSpuRelationVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 优惠券与产品关联 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface CouponSpuRelationMapper extends BaseMapper<CouponSpuRelation> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param couponSpuRelation
	 * @return
	 */
	List<CouponSpuRelationVO> selectCouponSpuRelationPage(IPage page, CouponSpuRelationVO couponSpuRelation);

}
