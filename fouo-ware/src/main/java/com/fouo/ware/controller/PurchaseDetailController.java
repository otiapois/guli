package com.fouo.ware.controller;

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
import com.fouo.ware.entity.PurchaseDetail;
import com.fouo.ware.vo.PurchaseDetailVO;
import com.fouo.ware.service.IPurchaseDetailService;

/**
 *  控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/ware/purchasedetail")
@Api(value = "", tags = "接口")
public class PurchaseDetailController  {

	private IPurchaseDetailService purchaseDetailService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入purchaseDetail")
	public R<PurchaseDetail> detail(PurchaseDetail purchaseDetail) {
		PurchaseDetail detail = purchaseDetailService.getOne(Condition.getQueryWrapper(purchaseDetail));
		return R.data(detail);
	}

	/**
	 * 分页 
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入purchaseDetail")
	public R<IPage<PurchaseDetail>> list(PurchaseDetail purchaseDetail, Query query) {
		IPage<PurchaseDetail> pages = purchaseDetailService.page(Condition.getPage(query), Condition.getQueryWrapper(purchaseDetail));
		return R.data(pages);
	}

	/**
	 * 自定义分页 
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入purchaseDetail")
	public R<IPage<PurchaseDetailVO>> page(PurchaseDetailVO purchaseDetail, Query query) {
		IPage<PurchaseDetailVO> pages = purchaseDetailService.selectPurchaseDetailPage(Condition.getPage(query), purchaseDetail);
		return R.data(pages);
	}

	/**
	 * 新增 
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入purchaseDetail")
	public R save(@Valid @RequestBody PurchaseDetail purchaseDetail) {
		return R.status(purchaseDetailService.save(purchaseDetail));
	}

	/**
	 * 修改 
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入purchaseDetail")
	public R update(@Valid @RequestBody PurchaseDetail purchaseDetail) {
		return R.status(purchaseDetailService.updateById(purchaseDetail));
	}

	/**
	 * 新增或修改 
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入purchaseDetail")
	public R submit(@Valid @RequestBody PurchaseDetail purchaseDetail) {
		return R.status(purchaseDetailService.saveOrUpdate(purchaseDetail));
	}

	
	/**
	 * 删除 
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(purchaseDetailService.removeByIds(Func.toLongList(ids)));
	}

	
}
