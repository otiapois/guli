package com.fouo.coupon.service;

import com.fouo.coupon.entity.SeckillSession;
import com.fouo.coupon.vo.SeckillSessionVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 秒杀活动场次 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface ISeckillSessionService extends IService<SeckillSession> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param seckillSession
	 * @return
	 */
	IPage<SeckillSessionVO> selectSeckillSessionPage(IPage<SeckillSessionVO> page, SeckillSessionVO seckillSession);

}
