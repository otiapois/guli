package com.fouo.coupon.controller;

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
import com.fouo.coupon.entity.HomeSubjectSpu;
import com.fouo.coupon.vo.HomeSubjectSpuVO;
import com.fouo.coupon.service.IHomeSubjectSpuService;

/**
 * 专题商品 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/homesubjectspu")
@Api(value = "专题商品", tags = "专题商品接口")
public class HomeSubjectSpuController{

	private IHomeSubjectSpuService homeSubjectSpuService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入homeSubjectSpu")
	public R<HomeSubjectSpu> detail(HomeSubjectSpu homeSubjectSpu) {
		HomeSubjectSpu detail = homeSubjectSpuService.getOne(Condition.getQueryWrapper(homeSubjectSpu));
		return R.data(detail);
	}

	/**
	 * 分页 专题商品
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入homeSubjectSpu")
	public R<IPage<HomeSubjectSpu>> list(HomeSubjectSpu homeSubjectSpu, Query query) {
		IPage<HomeSubjectSpu> pages = homeSubjectSpuService.page(Condition.getPage(query), Condition.getQueryWrapper(homeSubjectSpu));
		return R.data(pages);
	}

	/**
	 * 自定义分页 专题商品
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入homeSubjectSpu")
	public R<IPage<HomeSubjectSpuVO>> page(HomeSubjectSpuVO homeSubjectSpu, Query query) {
		IPage<HomeSubjectSpuVO> pages = homeSubjectSpuService.selectHomeSubjectSpuPage(Condition.getPage(query), homeSubjectSpu);
		return R.data(pages);
	}

	/**
	 * 新增 专题商品
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入homeSubjectSpu")
	public R save(@Valid @RequestBody HomeSubjectSpu homeSubjectSpu) {
		return R.status(homeSubjectSpuService.save(homeSubjectSpu));
	}

	/**
	 * 修改 专题商品
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入homeSubjectSpu")
	public R update(@Valid @RequestBody HomeSubjectSpu homeSubjectSpu) {
		return R.status(homeSubjectSpuService.updateById(homeSubjectSpu));
	}

	/**
	 * 新增或修改 专题商品
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入homeSubjectSpu")
	public R submit(@Valid @RequestBody HomeSubjectSpu homeSubjectSpu) {
		return R.status(homeSubjectSpuService.saveOrUpdate(homeSubjectSpu));
	}

	
	/**
	 * 删除 专题商品
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(homeSubjectSpuService.removeByIds(Func.toLongList(ids)));
	}

	
}
