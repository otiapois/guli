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
import com.fouo.order.entity.OrderOperateHistory;
import com.fouo.order.vo.OrderOperateHistoryVO;
import com.fouo.order.service.IOrderOperateHistoryService;

/**
 * 订单操作历史记录 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/orderoperatehistory")
@Api(value = "订单操作历史记录", tags = "订单操作历史记录接口")
public class OrderOperateHistoryController  {

	private IOrderOperateHistoryService orderOperateHistoryService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入orderOperateHistory")
	public R<OrderOperateHistory> detail(OrderOperateHistory orderOperateHistory) {
		OrderOperateHistory detail = orderOperateHistoryService.getOne(Condition.getQueryWrapper(orderOperateHistory));
		return R.data(detail);
	}

	/**
	 * 分页 订单操作历史记录
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入orderOperateHistory")
	public R<IPage<OrderOperateHistory>> list(OrderOperateHistory orderOperateHistory, Query query) {
		IPage<OrderOperateHistory> pages = orderOperateHistoryService.page(Condition.getPage(query), Condition.getQueryWrapper(orderOperateHistory));
		return R.data(pages);
	}

	/**
	 * 自定义分页 订单操作历史记录
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入orderOperateHistory")
	public R<IPage<OrderOperateHistoryVO>> page(OrderOperateHistoryVO orderOperateHistory, Query query) {
		IPage<OrderOperateHistoryVO> pages = orderOperateHistoryService.selectOrderOperateHistoryPage(Condition.getPage(query), orderOperateHistory);
		return R.data(pages);
	}

	/**
	 * 新增 订单操作历史记录
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入orderOperateHistory")
	public R save(@Valid @RequestBody OrderOperateHistory orderOperateHistory) {
		return R.status(orderOperateHistoryService.save(orderOperateHistory));
	}

	/**
	 * 修改 订单操作历史记录
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入orderOperateHistory")
	public R update(@Valid @RequestBody OrderOperateHistory orderOperateHistory) {
		return R.status(orderOperateHistoryService.updateById(orderOperateHistory));
	}

	/**
	 * 新增或修改 订单操作历史记录
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入orderOperateHistory")
	public R submit(@Valid @RequestBody OrderOperateHistory orderOperateHistory) {
		return R.status(orderOperateHistoryService.saveOrUpdate(orderOperateHistory));
	}

	
	/**
	 * 删除 订单操作历史记录
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(orderOperateHistoryService.removeByIds(Func.toLongList(ids)));
	}

	
}
