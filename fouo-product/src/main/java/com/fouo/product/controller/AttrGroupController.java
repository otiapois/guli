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
import com.fouo.product.entity.AttrGroup;
import com.fouo.product.vo.AttrGroupVO;
import com.fouo.product.service.IAttrGroupService;

/**
 * 属性分组 控制器
 *
 * @author fouo
 * @since 2020-06-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/attrgroup")
@Api(value = "属性分组", tags = "属性分组接口")
public class AttrGroupController {

	private IAttrGroupService attrGroupService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入attrGroup")
	public R<AttrGroup> detail(AttrGroup attrGroup) {
		AttrGroup detail = attrGroupService.getOne(Condition.getQueryWrapper(attrGroup));
		return R.data(detail);
	}

	/**
	 * 分页 属性分组
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入attrGroup")
	public R<IPage<AttrGroup>> list(AttrGroup attrGroup, Query query) {
		IPage<AttrGroup> pages = attrGroupService.page(Condition.getPage(query), Condition.getQueryWrapper(attrGroup));
		return R.data(pages);
	}

	/**
	 * 自定义分页 属性分组
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入attrGroup")
	public R<IPage<AttrGroupVO>> page(AttrGroupVO attrGroup, Query query) {
		IPage<AttrGroupVO> pages = attrGroupService.selectAttrGroupPage(Condition.getPage(query), attrGroup);
		return R.data(pages);
	}

	/**
	 * 新增 属性分组
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入attrGroup")
	public R save(@Valid @RequestBody AttrGroup attrGroup) {
		return R.status(attrGroupService.save(attrGroup));
	}

	/**
	 * 修改 属性分组
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入attrGroup")
	public R update(@Valid @RequestBody AttrGroup attrGroup) {
		return R.status(attrGroupService.updateById(attrGroup));
	}

	/**
	 * 新增或修改 属性分组
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入attrGroup")
	public R submit(@Valid @RequestBody AttrGroup attrGroup) {
		return R.status(attrGroupService.saveOrUpdate(attrGroup));
	}

	
	/**
	 * 删除 属性分组
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(attrGroupService.removeByIds(Func.toLongList(ids)));
	}

	
}
