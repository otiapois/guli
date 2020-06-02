package com.fouo.coupon.service.impl;

import com.fouo.coupon.entity.SeckillSkuNotice;
import com.fouo.coupon.vo.SeckillSkuNoticeVO;
import com.fouo.coupon.mapper.SeckillSkuNoticeMapper;
import com.fouo.coupon.service.ISeckillSkuNoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 秒杀商品通知订阅 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class SeckillSkuNoticeServiceImpl extends ServiceImpl<SeckillSkuNoticeMapper, SeckillSkuNotice> implements ISeckillSkuNoticeService {

	@Override
	public IPage<SeckillSkuNoticeVO> selectSeckillSkuNoticePage(IPage<SeckillSkuNoticeVO> page, SeckillSkuNoticeVO seckillSkuNotice) {
		return page.setRecords(baseMapper.selectSeckillSkuNoticePage(page, seckillSkuNotice));
	}

}
