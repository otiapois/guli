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
import com.fouo.order.entity.Order;
import com.fouo.order.vo.OrderVO;
import com.fouo.order.service.IOrderService;

/**
 * 订单 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/order")
@Api(value = "订单", tags = "订单接口")
public class OrderController  {

	private IOrderService orderService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入order")
	public R<Order> detail(Order order) {
		Order detail = orderService.getOne(Condition.getQueryWrapper(order));
		return R.data(detail);
	}

	/**
	 * 分页 订单
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入order")
	public R<IPage<Order>> list(Order order, Query query) {
		IPage<Order> pages = orderService.page(Condition.getPage(query), Condition.getQueryWrapper(order));
		return R.data(pages);
	}

	/**
	 * 自定义分页 订单
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入order")
	public R<IPage<OrderVO>> page(OrderVO order, Query query) {
		IPage<OrderVO> pages = orderService.selectOrderPage(Condition.getPage(query), order);
		return R.data(pages);
	}

	/**
	 * 新增 订单
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入order")
	public R save(@Valid @RequestBody Order order) {
		return R.status(orderService.save(order));
	}

	/**
	 * 修改 订单
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入order")
	public R update(@Valid @RequestBody Order order) {
		return R.status(orderService.updateById(order));
	}

	/**
	 * 新增或修改 订单
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入order")
	public R submit(@Valid @RequestBody Order order) {
		return R.status(orderService.saveOrUpdate(order));
	}

	
	/**
	 * 删除 订单
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(orderService.removeByIds(Func.toLongList(ids)));
	}

	
}
