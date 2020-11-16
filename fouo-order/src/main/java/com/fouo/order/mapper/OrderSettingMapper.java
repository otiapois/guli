package com.fouo.order.mapper;

import com.fouo.order.entity.OrderSetting;
import com.fouo.order.vo.OrderSettingVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 订单配置信息 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface OrderSettingMapper extends BaseMapper<OrderSetting> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param orderSetting
	 * @return
	 */
	List<OrderSettingVO> selectOrderSettingPage(IPage page, OrderSettingVO orderSetting);

}
