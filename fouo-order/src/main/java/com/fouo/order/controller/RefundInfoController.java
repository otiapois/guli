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
import com.fouo.order.entity.RefundInfo;
import com.fouo.order.vo.RefundInfoVO;
import com.fouo.order.service.IRefundInfoService;

/**
 * 退款信息 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/refundinfo")
@Api(value = "退款信息", tags = "退款信息接口")
public class RefundInfoController {

	private IRefundInfoService refundInfoService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入refundInfo")
	public R<RefundInfo> detail(RefundInfo refundInfo) {
		RefundInfo detail = refundInfoService.getOne(Condition.getQueryWrapper(refundInfo));
		return R.data(detail);
	}

	/**
	 * 分页 退款信息
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入refundInfo")
	public R<IPage<RefundInfo>> list(RefundInfo refundInfo, Query query) {
		IPage<RefundInfo> pages = refundInfoService.page(Condition.getPage(query), Condition.getQueryWrapper(refundInfo));
		return R.data(pages);
	}

	/**
	 * 自定义分页 退款信息
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入refundInfo")
	public R<IPage<RefundInfoVO>> page(RefundInfoVO refundInfo, Query query) {
		IPage<RefundInfoVO> pages = refundInfoService.selectRefundInfoPage(Condition.getPage(query), refundInfo);
		return R.data(pages);
	}

	/**
	 * 新增 退款信息
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入refundInfo")
	public R save(@Valid @RequestBody RefundInfo refundInfo) {
		return R.status(refundInfoService.save(refundInfo));
	}

	/**
	 * 修改 退款信息
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入refundInfo")
	public R update(@Valid @RequestBody RefundInfo refundInfo) {
		return R.status(refundInfoService.updateById(refundInfo));
	}

	/**
	 * 新增或修改 退款信息
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入refundInfo")
	public R submit(@Valid @RequestBody RefundInfo refundInfo) {
		return R.status(refundInfoService.saveOrUpdate(refundInfo));
	}

	
	/**
	 * 删除 退款信息
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(refundInfoService.removeByIds(Func.toLongList(ids)));
	}

	
}
