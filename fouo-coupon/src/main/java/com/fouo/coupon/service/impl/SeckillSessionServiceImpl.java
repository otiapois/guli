package com.fouo.coupon.service.impl;

import com.fouo.coupon.entity.SeckillSession;
import com.fouo.coupon.vo.SeckillSessionVO;
import com.fouo.coupon.mapper.SeckillSessionMapper;
import com.fouo.coupon.service.ISeckillSessionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 秒杀活动场次 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class SeckillSessionServiceImpl extends ServiceImpl<SeckillSessionMapper, SeckillSession> implements ISeckillSessionService {

	@Override
	public IPage<SeckillSessionVO> selectSeckillSessionPage(IPage<SeckillSessionVO> page, SeckillSessionVO seckillSession) {
		return page.setRecords(baseMapper.selectSeckillSessionPage(page, seckillSession));
	}

}
