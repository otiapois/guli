package com.fouo.coupon.mapper;

import com.fouo.coupon.entity.SeckillSession;
import com.fouo.coupon.vo.SeckillSessionVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 秒杀活动场次 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface SeckillSessionMapper extends BaseMapper<SeckillSession> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param seckillSession
	 * @return
	 */
	List<SeckillSessionVO> selectSeckillSessionPage(IPage page, SeckillSessionVO seckillSession);

}
