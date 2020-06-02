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
import com.fouo.order.entity.OrderReturnApply;
import com.fouo.order.vo.OrderReturnApplyVO;
import com.fouo.order.service.IOrderReturnApplyService;

/**
 * 订单退货申请 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/orderreturnapply")
@Api(value = "订单退货申请", tags = "订单退货申请接口")
public class OrderReturnApplyController {

	private IOrderReturnApplyService orderReturnApplyService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入orderReturnApply")
	public R<OrderReturnApply> detail(OrderReturnApply orderReturnApply) {
		OrderReturnApply detail = orderReturnApplyService.getOne(Condition.getQueryWrapper(orderReturnApply));
		return R.data(detail);
	}

	/**
	 * 分页 订单退货申请
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入orderReturnApply")
	public R<IPage<OrderReturnApply>> list(OrderReturnApply orderReturnApply, Query query) {
		IPage<OrderReturnApply> pages = orderReturnApplyService.page(Condition.getPage(query), Condition.getQueryWrapper(orderReturnApply));
		return R.data(pages);
	}

	/**
	 * 自定义分页 订单退货申请
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入orderReturnApply")
	public R<IPage<OrderReturnApplyVO>> page(OrderReturnApplyVO orderReturnApply, Query query) {
		IPage<OrderReturnApplyVO> pages = orderReturnApplyService.selectOrderReturnApplyPage(Condition.getPage(query), orderReturnApply);
		return R.data(pages);
	}

	/**
	 * 新增 订单退货申请
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入orderReturnApply")
	public R save(@Valid @RequestBody OrderReturnApply orderReturnApply) {
		return R.status(orderReturnApplyService.save(orderReturnApply));
	}

	/**
	 * 修改 订单退货申请
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入orderReturnApply")
	public R update(@Valid @RequestBody OrderReturnApply orderReturnApply) {
		return R.status(orderReturnApplyService.updateById(orderReturnApply));
	}

	/**
	 * 新增或修改 订单退货申请
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入orderReturnApply")
	public R submit(@Valid @RequestBody OrderReturnApply orderReturnApply) {
		return R.status(orderReturnApplyService.saveOrUpdate(orderReturnApply));
	}

	
	/**
	 * 删除 订单退货申请
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(orderReturnApplyService.removeByIds(Func.toLongList(ids)));
	}

	
}
