package com.fouo.product.controller;

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
import com.fouo.product.entity.SpuInfoDesc;
import com.fouo.product.vo.SpuInfoDescVO;
import com.fouo.product.service.ISpuInfoDescService;

/**
 * spu信息介绍 控制器
 *
 * @author fouo
 * @since 2020-06-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/spuinfodesc")
@Api(value = "spu信息介绍", tags = "spu信息介绍接口")
public class SpuInfoDescController {

	private ISpuInfoDescService spuInfoDescService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入spuInfoDesc")
	public R<SpuInfoDesc> detail(SpuInfoDesc spuInfoDesc) {
		SpuInfoDesc detail = spuInfoDescService.getOne(Condition.getQueryWrapper(spuInfoDesc));
		return R.data(detail);
	}

	/**
	 * 分页 spu信息介绍
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入spuInfoDesc")
	public R<IPage<SpuInfoDesc>> list(SpuInfoDesc spuInfoDesc, Query query) {
		IPage<SpuInfoDesc> pages = spuInfoDescService.page(Condition.getPage(query), Condition.getQueryWrapper(spuInfoDesc));
		return R.data(pages);
	}

	/**
	 * 自定义分页 spu信息介绍
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入spuInfoDesc")
	public R<IPage<SpuInfoDescVO>> page(SpuInfoDescVO spuInfoDesc, Query query) {
		IPage<SpuInfoDescVO> pages = spuInfoDescService.selectSpuInfoDescPage(Condition.getPage(query), spuInfoDesc);
		return R.data(pages);
	}

	/**
	 * 新增 spu信息介绍
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入spuInfoDesc")
	public R save(@Valid @RequestBody SpuInfoDesc spuInfoDesc) {
		return R.status(spuInfoDescService.save(spuInfoDesc));
	}

	/**
	 * 修改 spu信息介绍
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入spuInfoDesc")
	public R update(@Valid @RequestBody SpuInfoDesc spuInfoDesc) {
		return R.status(spuInfoDescService.updateById(spuInfoDesc));
	}

	/**
	 * 新增或修改 spu信息介绍
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入spuInfoDesc")
	public R submit(@Valid @RequestBody SpuInfoDesc spuInfoDesc) {
		return R.status(spuInfoDescService.saveOrUpdate(spuInfoDesc));
	}

	
	/**
	 * 删除 spu信息介绍
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(spuInfoDescService.removeByIds(Func.toLongList(ids)));
	}

	
}
