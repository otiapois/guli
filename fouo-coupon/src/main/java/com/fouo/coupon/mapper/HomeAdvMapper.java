package com.fouo.coupon.mapper;

import com.fouo.coupon.entity.HomeAdv;
import com.fouo.coupon.vo.HomeAdvVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 首页轮播广告 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface HomeAdvMapper extends BaseMapper<HomeAdv> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param homeAdv
	 * @return
	 */
	List<HomeAdvVO> selectHomeAdvPage(IPage page, HomeAdvVO homeAdv);

}
