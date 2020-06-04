package com.fouo.order.controller;

import com.fouo.common.support.Condition;
import com.fouo.common.support.Query;
import com.fouo.common.support.R;
import com.fouo.common.utils.Func;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.order.entity.OrderItem;
import com.fouo.order.vo.OrderItemVO;
import com.fouo.order.service.IOrderItemService;

/**
 * 订单项信息 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/orderitem")
@Api(value = "订单项信息", tags = "订单项信息接口")
public class OrderItemController{

	private IOrderItemService orderItemService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入orderItem")
	public R<OrderItem> detail(OrderItem orderItem) {
		OrderItem detail = orderItemService.getOne(Condition.getQueryWrapper(orderItem));
		return R.data(detail);
	}

	/**
	 * 分页 订单项信息
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入orderItem")
	public R<IPage<OrderItem>> list(OrderItem orderItem, Query query) {
		IPage<OrderItem> pages = orderItemService.page(Condition.getPage(query), Condition.getQueryWrapper(orderItem));
		return R.data(pages);
	}

	/**
	 * 自定义分页 订单项信息
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入orderItem")
	public R<IPage<OrderItemVO>> page(OrderItemVO orderItem, Query query) {
		IPage<OrderItemVO> pages = orderItemService.selectOrderItemPage(Condition.getPage(query), orderItem);
		return R.data(pages);
	}

	/**
	 * 新增 订单项信息
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入orderItem")
	public R save(@Valid @RequestBody OrderItem orderItem) {
		return R.status(orderItemService.save(orderItem));
	}

	/**
	 * 修改 订单项信息
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入orderItem")
	public R update(@Valid @RequestBody OrderItem orderItem) {
		return R.status(orderItemService.updateById(orderItem));
	}

	/**
	 * 新增或修改 订单项信息
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入orderItem")
	public R submit(@Valid @RequestBody OrderItem orderItem) {
		return R.status(orderItemService.saveOrUpdate(orderItem));
	}

	
	/**
	 * 删除 订单项信息
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(orderItemService.removeByIds(Func.toLongList(ids)));
	}

	
}
