package com.fouo.coupon.mapper;

import com.fouo.coupon.entity.MemberPrice;
import com.fouo.coupon.vo.MemberPriceVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 商品会员价格 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface MemberPriceMapper extends BaseMapper<MemberPrice> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param memberPrice
	 * @return
	 */
	List<MemberPriceVO> selectMemberPricePage(IPage page, MemberPriceVO memberPrice);

}
