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
import com.fouo.order.entity.OrderReturnReason;
import com.fouo.order.vo.OrderReturnReasonVO;
import com.fouo.order.service.IOrderReturnReasonService;

/**
 * 退货原因 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/orderreturnreason")
@Api(value = "退货原因", tags = "退货原因接口")
public class OrderReturnReasonController{

	private IOrderReturnReasonService orderReturnReasonService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入orderReturnReason")
	public R<OrderReturnReason> detail(OrderReturnReason orderReturnReason) {
		OrderReturnReason detail = orderReturnReasonService.getOne(Condition.getQueryWrapper(orderReturnReason));
		return R.data(detail);
	}

	/**
	 * 分页 退货原因
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入orderReturnReason")
	public R<IPage<OrderReturnReason>> list(OrderReturnReason orderReturnReason, Query query) {
		IPage<OrderReturnReason> pages = orderReturnReasonService.page(Condition.getPage(query), Condition.getQueryWrapper(orderReturnReason));
		return R.data(pages);
	}

	/**
	 * 自定义分页 退货原因
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入orderReturnReason")
	public R<IPage<OrderReturnReasonVO>> page(OrderReturnReasonVO orderReturnReason, Query query) {
		IPage<OrderReturnReasonVO> pages = orderReturnReasonService.selectOrderReturnReasonPage(Condition.getPage(query), orderReturnReason);
		return R.data(pages);
	}

	/**
	 * 新增 退货原因
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入orderReturnReason")
	public R save(@Valid @RequestBody OrderReturnReason orderReturnReason) {
		return R.status(orderReturnReasonService.save(orderReturnReason));
	}

	/**
	 * 修改 退货原因
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入orderReturnReason")
	public R update(@Valid @RequestBody OrderReturnReason orderReturnReason) {
		return R.status(orderReturnReasonService.updateById(orderReturnReason));
	}

	/**
	 * 新增或修改 退货原因
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入orderReturnReason")
	public R submit(@Valid @RequestBody OrderReturnReason orderReturnReason) {
		return R.status(orderReturnReasonService.saveOrUpdate(orderReturnReason));
	}

	
	/**
	 * 删除 退货原因
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(orderReturnReasonService.removeByIds(Func.toLongList(ids)));
	}

	
}
