package com.fouo.order.service.impl;

import com.fouo.order.entity.RefundInfo;
import com.fouo.order.vo.RefundInfoVO;
import com.fouo.order.mapper.RefundInfoMapper;
import com.fouo.order.service.IRefundInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 退款信息 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class RefundInfoServiceImpl extends ServiceImpl<RefundInfoMapper, RefundInfo> implements IRefundInfoService {

	@Override
	public IPage<RefundInfoVO> selectRefundInfoPage(IPage<RefundInfoVO> page, RefundInfoVO refundInfo) {
		return page.setRecords(baseMapper.selectRefundInfoPage(page, refundInfo));
	}

}
