package com.fouo.ware.controller;

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
import com.fouo.ware.entity.WareOrderTask;
import com.fouo.ware.vo.WareOrderTaskVO;
import com.fouo.ware.service.IWareOrderTaskService;

/**
 * 库存工作单 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/wareordertask")
@Api(value = "库存工作单", tags = "库存工作单接口")
public class WareOrderTaskController{

	private IWareOrderTaskService wareOrderTaskService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入wareOrderTask")
	public R<WareOrderTask> detail(WareOrderTask wareOrderTask) {
		WareOrderTask detail = wareOrderTaskService.getOne(Condition.getQueryWrapper(wareOrderTask));
		return R.data(detail);
	}

	/**
	 * 分页 库存工作单
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入wareOrderTask")
	public R<IPage<WareOrderTask>> list(WareOrderTask wareOrderTask, Query query) {
		IPage<WareOrderTask> pages = wareOrderTaskService.page(Condition.getPage(query), Condition.getQueryWrapper(wareOrderTask));
		return R.data(pages);
	}

	/**
	 * 自定义分页 库存工作单
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入wareOrderTask")
	public R<IPage<WareOrderTaskVO>> page(WareOrderTaskVO wareOrderTask, Query query) {
		IPage<WareOrderTaskVO> pages = wareOrderTaskService.selectWareOrderTaskPage(Condition.getPage(query), wareOrderTask);
		return R.data(pages);
	}

	/**
	 * 新增 库存工作单
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入wareOrderTask")
	public R save(@Valid @RequestBody WareOrderTask wareOrderTask) {
		return R.status(wareOrderTaskService.save(wareOrderTask));
	}

	/**
	 * 修改 库存工作单
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入wareOrderTask")
	public R update(@Valid @RequestBody WareOrderTask wareOrderTask) {
		return R.status(wareOrderTaskService.updateById(wareOrderTask));
	}

	/**
	 * 新增或修改 库存工作单
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入wareOrderTask")
	public R submit(@Valid @RequestBody WareOrderTask wareOrderTask) {
		return R.status(wareOrderTaskService.saveOrUpdate(wareOrderTask));
	}

	
	/**
	 * 删除 库存工作单
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(wareOrderTaskService.removeByIds(Func.toLongList(ids)));
	}

	
}
