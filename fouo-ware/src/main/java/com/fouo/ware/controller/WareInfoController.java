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
import com.fouo.ware.entity.WareInfo;
import com.fouo.ware.vo.WareInfoVO;
import com.fouo.ware.service.IWareInfoService;

import java.util.Arrays;

/**
 * 仓库信息 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/ware/wareinfo")
@Api(value = "仓库信息", tags = "仓库信息接口")
public class WareInfoController {

	private IWareInfoService wareInfoService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入wareInfo")
	public R<WareInfo> detail(WareInfo wareInfo) {
		WareInfo detail = wareInfoService.getOne(Condition.getQueryWrapper(wareInfo));
		return R.data(detail);
	}

	/**
	 * 分页 仓库信息
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入wareInfo")
	public R<IPage<WareInfo>> list(WareInfo wareInfo, Query query) {
		IPage<WareInfo> pages = wareInfoService.page(Condition.getPage(query), Condition.getQueryWrapper(wareInfo));
		return R.data(pages);
	}

	/**
	 * 自定义分页 仓库信息
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入wareInfo")
	public R<IPage<WareInfoVO>> page(WareInfoVO wareInfo, Query query) {
		IPage<WareInfoVO> pages = wareInfoService.selectWareInfoPage(Condition.getPage(query), wareInfo);
		return R.data(pages);
	}

	/**
	 * 新增 仓库信息
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入wareInfo")
	public R save(@Valid @RequestBody WareInfo wareInfo) {
		return R.status(wareInfoService.save(wareInfo));
	}

	/**
	 * 修改 仓库信息
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入wareInfo")
	public R update(@Valid @RequestBody WareInfo wareInfo) {
		return R.status(wareInfoService.updateById(wareInfo));
	}

	/**
	 * 新增或修改 仓库信息
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入wareInfo")
	public R submit(@Valid @RequestBody WareInfo wareInfo) {
		return R.status(wareInfoService.saveOrUpdate(wareInfo));
	}

	
	/**
	 * 删除 仓库信息
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody Long[] ids) {
		return R.status(wareInfoService.removeByIds(Arrays.asList(ids)));
	}
}
