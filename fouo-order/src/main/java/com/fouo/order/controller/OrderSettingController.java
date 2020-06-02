package com.fouo.order.controller;

import com.fouo.common.support.Condition;
import com.fouo.common.support.Query;
import com.fouo.common.support.R;
import com.fouo.common.utils.Func;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.order.entity.OrderSetting;
import com.fouo.order.vo.OrderSettingVO;
import com.fouo.order.service.IOrderSettingService;

/**
 * 订单配置信息 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/ordersetting")
@Api(value = "订单配置信息", tags = "订单配置信息接口")
public class OrderSettingController{

	private IOrderSettingService orderSettingService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入orderSetting")
	public R<OrderSetting> detail(OrderSetting orderSetting) {
		OrderSetting detail = orderSettingService.getOne(Condition.getQueryWrapper(orderSetting));
		return R.data(detail);
	}

	/**
	 * 分页 订单配置信息
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入orderSetting")
	public R<IPage<OrderSetting>> list(OrderSetting orderSetting, Query query) {
		IPage<OrderSetting> pages = orderSettingService.page(Condition.getPage(query), Condition.getQueryWrapper(orderSetting));
		return R.data(pages);
	}

	/**
	 * 自定义分页 订单配置信息
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入orderSetting")
	public R<IPage<OrderSettingVO>> page(OrderSettingVO orderSetting, Query query) {
		IPage<OrderSettingVO> pages = orderSettingService.selectOrderSettingPage(Condition.getPage(query), orderSetting);
		return R.data(pages);
	}

	/**
	 * 新增 订单配置信息
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入orderSetting")
	public R save(@Valid @RequestBody OrderSetting orderSetting) {
		return R.status(orderSettingService.save(orderSetting));
	}

	/**
	 * 修改 订单配置信息
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入orderSetting")
	public R update(@Valid @RequestBody OrderSetting orderSetting) {
		return R.status(orderSettingService.updateById(orderSetting));
	}

	/**
	 * 新增或修改 订单配置信息
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入orderSetting")
	public R submit(@Valid @RequestBody OrderSetting orderSetting) {
		return R.status(orderSettingService.saveOrUpdate(orderSetting));
	}

	
	/**
	 * 删除 订单配置信息
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(orderSettingService.removeByIds(Func.toLongList(ids)));
	}

	
}
