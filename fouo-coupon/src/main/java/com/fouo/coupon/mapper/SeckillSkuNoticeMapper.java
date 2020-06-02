package com.fouo.coupon.mapper;

import com.fouo.coupon.entity.SeckillSkuNotice;
import com.fouo.coupon.vo.SeckillSkuNoticeVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 秒杀商品通知订阅 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface SeckillSkuNoticeMapper extends BaseMapper<SeckillSkuNotice> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param seckillSkuNotice
	 * @return
	 */
	List<SeckillSkuNoticeVO> selectSeckillSkuNoticePage(IPage page, SeckillSkuNoticeVO seckillSkuNotice);

}
