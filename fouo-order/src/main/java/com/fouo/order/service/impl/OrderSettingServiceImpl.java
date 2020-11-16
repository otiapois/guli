package com.fouo.order.service.impl;

import com.fouo.order.entity.OrderSetting;
import com.fouo.order.vo.OrderSettingVO;
import com.fouo.order.mapper.OrderSettingMapper;
import com.fouo.order.service.IOrderSettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 订单配置信息 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class OrderSettingServiceImpl extends ServiceImpl<OrderSettingMapper, OrderSetting> implements IOrderSettingService {

	@Override
	public IPage<OrderSettingVO> selectOrderSettingPage(IPage<OrderSettingVO> page, OrderSettingVO orderSetting) {
		return page.setRecords(baseMapper.selectOrderSettingPage(page, orderSetting));
	}

}
