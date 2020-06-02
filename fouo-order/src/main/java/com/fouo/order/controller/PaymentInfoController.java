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
import com.fouo.order.entity.PaymentInfo;
import com.fouo.order.vo.PaymentInfoVO;
import com.fouo.order.service.IPaymentInfoService;

/**
 * 支付信息表 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/paymentinfo")
@Api(value = "支付信息表", tags = "支付信息表接口")
public class PaymentInfoController {

	private IPaymentInfoService paymentInfoService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入paymentInfo")
	public R<PaymentInfo> detail(PaymentInfo paymentInfo) {
		PaymentInfo detail = paymentInfoService.getOne(Condition.getQueryWrapper(paymentInfo));
		return R.data(detail);
	}

	/**
	 * 分页 支付信息表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入paymentInfo")
	public R<IPage<PaymentInfo>> list(PaymentInfo paymentInfo, Query query) {
		IPage<PaymentInfo> pages = paymentInfoService.page(Condition.getPage(query), Condition.getQueryWrapper(paymentInfo));
		return R.data(pages);
	}

	/**
	 * 自定义分页 支付信息表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入paymentInfo")
	public R<IPage<PaymentInfoVO>> page(PaymentInfoVO paymentInfo, Query query) {
		IPage<PaymentInfoVO> pages = paymentInfoService.selectPaymentInfoPage(Condition.getPage(query), paymentInfo);
		return R.data(pages);
	}

	/**
	 * 新增 支付信息表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入paymentInfo")
	public R save(@Valid @RequestBody PaymentInfo paymentInfo) {
		return R.status(paymentInfoService.save(paymentInfo));
	}

	/**
	 * 修改 支付信息表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入paymentInfo")
	public R update(@Valid @RequestBody PaymentInfo paymentInfo) {
		return R.status(paymentInfoService.updateById(paymentInfo));
	}

	/**
	 * 新增或修改 支付信息表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入paymentInfo")
	public R submit(@Valid @RequestBody PaymentInfo paymentInfo) {
		return R.status(paymentInfoService.saveOrUpdate(paymentInfo));
	}

	
	/**
	 * 删除 支付信息表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(paymentInfoService.removeByIds(Func.toLongList(ids)));
	}

	
}
