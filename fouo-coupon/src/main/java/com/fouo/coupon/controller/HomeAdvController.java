package com.fouo.coupon.controller;

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
import com.fouo.coupon.entity.HomeAdv;
import com.fouo.coupon.vo.HomeAdvVO;
import com.fouo.coupon.service.IHomeAdvService;

/**
 * 首页轮播广告 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/homeadv")
@Api(value = "首页轮播广告", tags = "首页轮播广告接口")
public class HomeAdvController  {

	private IHomeAdvService homeAdvService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入homeAdv")
	public R<HomeAdv> detail(HomeAdv homeAdv) {
		HomeAdv detail = homeAdvService.getOne(Condition.getQueryWrapper(homeAdv));
		return R.data(detail);
	}

	/**
	 * 分页 首页轮播广告
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入homeAdv")
	public R<IPage<HomeAdv>> list(HomeAdv homeAdv, Query query) {
		IPage<HomeAdv> pages = homeAdvService.page(Condition.getPage(query), Condition.getQueryWrapper(homeAdv));
		return R.data(pages);
	}

	/**
	 * 自定义分页 首页轮播广告
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入homeAdv")
	public R<IPage<HomeAdvVO>> page(HomeAdvVO homeAdv, Query query) {
		IPage<HomeAdvVO> pages = homeAdvService.selectHomeAdvPage(Condition.getPage(query), homeAdv);
		return R.data(pages);
	}

	/**
	 * 新增 首页轮播广告
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入homeAdv")
	public R save(@Valid @RequestBody HomeAdv homeAdv) {
		return R.status(homeAdvService.save(homeAdv));
	}

	/**
	 * 修改 首页轮播广告
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入homeAdv")
	public R update(@Valid @RequestBody HomeAdv homeAdv) {
		return R.status(homeAdvService.updateById(homeAdv));
	}

	/**
	 * 新增或修改 首页轮播广告
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入homeAdv")
	public R submit(@Valid @RequestBody HomeAdv homeAdv) {
		return R.status(homeAdvService.saveOrUpdate(homeAdv));
	}

	
	/**
	 * 删除 首页轮播广告
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(homeAdvService.removeByIds(Func.toLongList(ids)));
	}

	
}
