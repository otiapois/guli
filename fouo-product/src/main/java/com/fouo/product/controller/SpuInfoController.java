package com.fouo.product.controller;

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
import com.fouo.product.entity.SpuInfo;
import com.fouo.product.vo.SpuInfoVO;
import com.fouo.product.service.ISpuInfoService;

/**
 * spu信息 控制器
 *
 * @author fouo
 * @since 2020-06-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/product/spuinfo")
@Api(value = "spu信息", tags = "spu信息接口")
public class SpuInfoController {

	private ISpuInfoService spuInfoService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入spuInfo")
	public R<SpuInfo> detail(SpuInfo spuInfo) {
		SpuInfo detail = spuInfoService.getOne(Condition.getQueryWrapper(spuInfo));
		return R.data(detail);
	}

	/**
	 * 分页 spu信息
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入spuInfo")
	public R<IPage<SpuInfo>> list(SpuInfo spuInfo, Query query) {
		IPage<SpuInfo> pages = spuInfoService.page(Condition.getPage(query), Condition.getQueryWrapper(spuInfo));
		return R.data(pages);
	}

	/**
	 * 自定义分页 spu信息
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入spuInfo")
	public R<IPage<SpuInfoVO>> page(SpuInfoVO spuInfo, Query query) {
		IPage<SpuInfoVO> pages = spuInfoService.selectSpuInfoPage(Condition.getPage(query), spuInfo);
		return R.data(pages);
	}

	/**
	 * 新增 spu信息
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入spuInfo")
	public R save(@Valid @RequestBody SpuInfoVO spuInfoVO) {
		return R.status(spuInfoService.saveSpuInfo(spuInfoVO));
	}

	/**
	 * 修改 spu信息
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入spuInfo")
	public R update(@Valid @RequestBody SpuInfo spuInfo) {
		return R.status(spuInfoService.updateById(spuInfo));
	}

	/**
	 * 新增或修改 spu信息
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入spuInfo")
	public R submit(@Valid @RequestBody SpuInfo spuInfo) {
		return R.status(spuInfoService.saveOrUpdate(spuInfo));
	}

	
	/**
	 * 删除 spu信息
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(spuInfoService.removeByIds(Func.toLongList(ids)));
	}

	
}
