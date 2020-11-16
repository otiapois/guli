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
import com.fouo.ware.entity.WareOrderTaskDetail;
import com.fouo.ware.vo.WareOrderTaskDetailVO;
import com.fouo.ware.service.IWareOrderTaskDetailService;

/**
 * 库存工作单 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/ware/wareordertaskdetail")
@Api(value = "库存工作单", tags = "库存工作单接口")
public class WareOrderTaskDetailController {

	private IWareOrderTaskDetailService wareOrderTaskDetailService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入wareOrderTaskDetail")
	public R<WareOrderTaskDetail> detail(WareOrderTaskDetail wareOrderTaskDetail) {
		WareOrderTaskDetail detail = wareOrderTaskDetailService.getOne(Condition.getQueryWrapper(wareOrderTaskDetail));
		return R.data(detail);
	}

	/**
	 * 分页 库存工作单
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入wareOrderTaskDetail")
	public R<IPage<WareOrderTaskDetail>> list(WareOrderTaskDetail wareOrderTaskDetail, Query query) {
		IPage<WareOrderTaskDetail> pages = wareOrderTaskDetailService.page(Condition.getPage(query), Condition.getQueryWrapper(wareOrderTaskDetail));
		return R.data(pages);
	}

	/**
	 * 自定义分页 库存工作单
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入wareOrderTaskDetail")
	public R<IPage<WareOrderTaskDetailVO>> page(WareOrderTaskDetailVO wareOrderTaskDetail, Query query) {
		IPage<WareOrderTaskDetailVO> pages = wareOrderTaskDetailService.selectWareOrderTaskDetailPage(Condition.getPage(query), wareOrderTaskDetail);
		return R.data(pages);
	}

	/**
	 * 新增 库存工作单
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入wareOrderTaskDetail")
	public R save(@Valid @RequestBody WareOrderTaskDetail wareOrderTaskDetail) {
		return R.status(wareOrderTaskDetailService.save(wareOrderTaskDetail));
	}

	/**
	 * 修改 库存工作单
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入wareOrderTaskDetail")
	public R update(@Valid @RequestBody WareOrderTaskDetail wareOrderTaskDetail) {
		return R.status(wareOrderTaskDetailService.updateById(wareOrderTaskDetail));
	}

	/**
	 * 新增或修改 库存工作单
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入wareOrderTaskDetail")
	public R submit(@Valid @RequestBody WareOrderTaskDetail wareOrderTaskDetail) {
		return R.status(wareOrderTaskDetailService.saveOrUpdate(wareOrderTaskDetail));
	}

	
	/**
	 * 删除 库存工作单
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(wareOrderTaskDetailService.removeByIds(Func.toLongList(ids)));
	}

	
}
