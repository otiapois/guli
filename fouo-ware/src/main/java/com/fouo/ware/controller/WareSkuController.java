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
import com.fouo.ware.entity.WareSku;
import com.fouo.ware.vo.WareSkuVO;
import com.fouo.ware.service.IWareSkuService;

/**
 * 商品库存 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/waresku")
@Api(value = "商品库存", tags = "商品库存接口")
public class WareSkuController {

	private IWareSkuService wareSkuService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入wareSku")
	public R<WareSku> detail(WareSku wareSku) {
		WareSku detail = wareSkuService.getOne(Condition.getQueryWrapper(wareSku));
		return R.data(detail);
	}

	/**
	 * 分页 商品库存
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入wareSku")
	public R<IPage<WareSku>> list(WareSku wareSku, Query query) {
		IPage<WareSku> pages = wareSkuService.page(Condition.getPage(query), Condition.getQueryWrapper(wareSku));
		return R.data(pages);
	}

	/**
	 * 自定义分页 商品库存
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入wareSku")
	public R<IPage<WareSkuVO>> page(WareSkuVO wareSku, Query query) {
		IPage<WareSkuVO> pages = wareSkuService.selectWareSkuPage(Condition.getPage(query), wareSku);
		return R.data(pages);
	}

	/**
	 * 新增 商品库存
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入wareSku")
	public R save(@Valid @RequestBody WareSku wareSku) {
		return R.status(wareSkuService.save(wareSku));
	}

	/**
	 * 修改 商品库存
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入wareSku")
	public R update(@Valid @RequestBody WareSku wareSku) {
		return R.status(wareSkuService.updateById(wareSku));
	}

	/**
	 * 新增或修改 商品库存
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入wareSku")
	public R submit(@Valid @RequestBody WareSku wareSku) {
		return R.status(wareSkuService.saveOrUpdate(wareSku));
	}

	
	/**
	 * 删除 商品库存
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(wareSkuService.removeByIds(Func.toLongList(ids)));
	}

	
}
