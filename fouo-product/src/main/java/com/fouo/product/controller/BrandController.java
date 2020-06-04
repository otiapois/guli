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
import com.fouo.product.entity.Brand;
import com.fouo.product.vo.BrandVO;
import com.fouo.product.service.IBrandService;

/**
 * 品牌 控制器
 *
 * @author fouo
 * @since 2020-06-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/brand")
@Api(value = "品牌", tags = "品牌接口")
public class BrandController  {

	private IBrandService brandService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入brand")
	public R<Brand> detail(Brand brand) {
		Brand detail = brandService.getOne(Condition.getQueryWrapper(brand));
		return R.data(detail);
	}

	/**
	 * 分页 品牌
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入brand")
	public R<IPage<Brand>> list(Brand brand, Query query) {
		IPage<Brand> pages = brandService.page(Condition.getPage(query), Condition.getQueryWrapper(brand));
		return R.data(pages);
	}

	/**
	 * 自定义分页 品牌
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入brand")
	public R<IPage<BrandVO>> page(BrandVO brand, Query query) {
		IPage<BrandVO> pages = brandService.selectBrandPage(Condition.getPage(query), brand);
		return R.data(pages);
	}

	/**
	 * 新增 品牌
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入brand")
	public R save(@Valid @RequestBody Brand brand) {
		return R.status(brandService.save(brand));
	}

	/**
	 * 修改 品牌
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入brand")
	public R update(@Valid @RequestBody Brand brand) {
		return R.status(brandService.updateById(brand));
	}

	/**
	 * 新增或修改 品牌
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入brand")
	public R submit(@Valid @RequestBody Brand brand) {
		return R.status(brandService.saveOrUpdate(brand));
	}

	
	/**
	 * 删除 品牌
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(brandService.removeByIds(Func.toLongList(ids)));
	}

	
}
