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
import com.fouo.product.entity.Attr;
import com.fouo.product.vo.AttrVO;
import com.fouo.product.service.IAttrService;

/**
 * 商品属性 控制器
 *
 * @author fouo
 * @since 2020-06-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/attr")
@Api(value = "商品属性", tags = "商品属性接口")
public class AttrController {

	private IAttrService attrService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入attr")
	public R<Attr> detail(Attr attr) {
		Attr detail = attrService.getOne(Condition.getQueryWrapper(attr));
		return R.data(detail);
	}

	/**
	 * 分页 商品属性
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入attr")
	public R<IPage<Attr>> list(Attr attr, Query query) {
		IPage<Attr> pages = attrService.page(Condition.getPage(query), Condition.getQueryWrapper(attr));
		return R.data(pages);
	}

	/**
	 * 自定义分页 商品属性
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入attr")
	public R<IPage<AttrVO>> page(AttrVO attr, Query query) {
		IPage<AttrVO> pages = attrService.selectAttrPage(Condition.getPage(query), attr);
		return R.data(pages);
	}

	/**
	 * 新增 商品属性
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入attr")
	public R save(@Valid @RequestBody Attr attr) {
		return R.status(attrService.save(attr));
	}

	/**
	 * 修改 商品属性
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入attr")
	public R update(@Valid @RequestBody Attr attr) {
		return R.status(attrService.updateById(attr));
	}

	/**
	 * 新增或修改 商品属性
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入attr")
	public R submit(@Valid @RequestBody Attr attr) {
		return R.status(attrService.saveOrUpdate(attr));
	}

	
	/**
	 * 删除 商品属性
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(attrService.removeByIds(Func.toLongList(ids)));
	}

	
}
