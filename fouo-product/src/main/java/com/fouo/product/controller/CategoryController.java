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
import com.fouo.product.entity.Category;
import com.fouo.product.vo.CategoryVO;
import com.fouo.product.service.ICategoryService;

/**
 * 商品三级分类 控制器
 *
 * @author fouo
 * @since 2020-06-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/category")
@Api(value = "商品三级分类", tags = "商品三级分类接口")
public class CategoryController {

	private ICategoryService categoryService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入category")
	public R<Category> detail(Category category) {
		Category detail = categoryService.getOne(Condition.getQueryWrapper(category));
		return R.data(detail);
	}

	/**
	 * 分页 商品三级分类
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入category")
	public R<IPage<Category>> list(Category category, Query query) {
		IPage<Category> pages = categoryService.page(Condition.getPage(query), Condition.getQueryWrapper(category));
		return R.data(pages);
	}

	/**
	 * 自定义分页 商品三级分类
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入category")
	public R<IPage<CategoryVO>> page(CategoryVO category, Query query) {
		IPage<CategoryVO> pages = categoryService.selectCategoryPage(Condition.getPage(query), category);
		return R.data(pages);
	}

	/**
	 * 新增 商品三级分类
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入category")
	public R save(@Valid @RequestBody Category category) {
		return R.status(categoryService.save(category));
	}

	/**
	 * 修改 商品三级分类
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入category")
	public R update(@Valid @RequestBody Category category) {
		return R.status(categoryService.updateById(category));
	}

	/**
	 * 新增或修改 商品三级分类
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入category")
	public R submit(@Valid @RequestBody Category category) {
		return R.status(categoryService.saveOrUpdate(category));
	}

	
	/**
	 * 删除 商品三级分类
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(categoryService.removeByIds(Func.toLongList(ids)));
	}

	
}
