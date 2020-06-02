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
import com.fouo.coupon.entity.HomeSubject;
import com.fouo.coupon.vo.HomeSubjectVO;
import com.fouo.coupon.service.IHomeSubjectService;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/homesubject")
@Api(value = "首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】", tags = "首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】接口")
public class HomeSubjectController{

	private IHomeSubjectService homeSubjectService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入homeSubject")
	public R<HomeSubject> detail(HomeSubject homeSubject) {
		HomeSubject detail = homeSubjectService.getOne(Condition.getQueryWrapper(homeSubject));
		return R.data(detail);
	}

	/**
	 * 分页 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入homeSubject")
	public R<IPage<HomeSubject>> list(HomeSubject homeSubject, Query query) {
		IPage<HomeSubject> pages = homeSubjectService.page(Condition.getPage(query), Condition.getQueryWrapper(homeSubject));
		return R.data(pages);
	}

	/**
	 * 自定义分页 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入homeSubject")
	public R<IPage<HomeSubjectVO>> page(HomeSubjectVO homeSubject, Query query) {
		IPage<HomeSubjectVO> pages = homeSubjectService.selectHomeSubjectPage(Condition.getPage(query), homeSubject);
		return R.data(pages);
	}

	/**
	 * 新增 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入homeSubject")
	public R save(@Valid @RequestBody HomeSubject homeSubject) {
		return R.status(homeSubjectService.save(homeSubject));
	}

	/**
	 * 修改 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入homeSubject")
	public R update(@Valid @RequestBody HomeSubject homeSubject) {
		return R.status(homeSubjectService.updateById(homeSubject));
	}

	/**
	 * 新增或修改 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入homeSubject")
	public R submit(@Valid @RequestBody HomeSubject homeSubject) {
		return R.status(homeSubjectService.saveOrUpdate(homeSubject));
	}

	
	/**
	 * 删除 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(homeSubjectService.removeByIds(Func.toLongList(ids)));
	}

	
}
