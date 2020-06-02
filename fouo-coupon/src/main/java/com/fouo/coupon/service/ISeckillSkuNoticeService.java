package com.fouo.coupon.service;

import com.fouo.coupon.entity.SeckillSkuNotice;
import com.fouo.coupon.vo.SeckillSkuNoticeVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 秒杀商品通知订阅 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface ISeckillSkuNoticeService extends IService<SeckillSkuNotice> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param seckillSkuNotice
	 * @return
	 */
	IPage<SeckillSkuNoticeVO> selectSeckillSkuNoticePage(IPage<SeckillSkuNoticeVO> page, SeckillSkuNoticeVO seckillSkuNotice);

}
