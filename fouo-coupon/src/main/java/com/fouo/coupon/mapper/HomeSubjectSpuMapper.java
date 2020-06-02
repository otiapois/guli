package com.fouo.coupon.mapper;

import com.fouo.coupon.entity.HomeSubjectSpu;
import com.fouo.coupon.vo.HomeSubjectSpuVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 专题商品 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface HomeSubjectSpuMapper extends BaseMapper<HomeSubjectSpu> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param homeSubjectSpu
	 * @return
	 */
	List<HomeSubjectSpuVO> selectHomeSubjectSpuPage(IPage page, HomeSubjectSpuVO homeSubjectSpu);

}
