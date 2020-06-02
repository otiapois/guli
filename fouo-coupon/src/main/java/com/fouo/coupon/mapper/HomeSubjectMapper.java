package com.fouo.coupon.mapper;

import com.fouo.coupon.entity.HomeSubject;
import com.fouo.coupon.vo.HomeSubjectVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface HomeSubjectMapper extends BaseMapper<HomeSubject> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param homeSubject
	 * @return
	 */
	List<HomeSubjectVO> selectHomeSubjectPage(IPage page, HomeSubjectVO homeSubject);

}
