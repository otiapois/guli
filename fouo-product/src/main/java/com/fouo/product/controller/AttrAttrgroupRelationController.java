package com.fouo.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.common.support.Condition;
import com.fouo.common.support.Query;
import com.fouo.common.support.R;
import com.fouo.common.utils.Func;
import com.fouo.product.entity.AttrAttrgroupRelation;
import com.fouo.product.service.IAttrAttrgroupRelationService;
import com.fouo.product.vo.AttrAttrgroupRelationVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 属性&属性分组关联 控制器
 *
 * @author fouo
 * @since 2020-06-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/attrattrgrouprelation")
@Api(value = "属性&属性分组关联", tags = "属性&属性分组关联接口")
public class AttrAttrgroupRelationController  {

	private IAttrAttrgroupRelationService attrAttrgroupRelationService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入attrAttrgroupRelation")
	public R<AttrAttrgroupRelation> detail(AttrAttrgroupRelation attrAttrgroupRelation) {
		AttrAttrgroupRelation detail = attrAttrgroupRelationService.getOne(Condition.getQueryWrapper(attrAttrgroupRelation));
		return R.data(detail);
	}

	/**
	 * 分页 属性&属性分组关联
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入attrAttrgroupRelation")
	public R<IPage<AttrAttrgroupRelation>> list(AttrAttrgroupRelation attrAttrgroupRelation, Query query) {
		IPage<AttrAttrgroupRelation> pages = attrAttrgroupRelationService.page(Condition.getPage(query), Condition.getQueryWrapper(attrAttrgroupRelation));
		return R.data(pages);
	}

	/**
	 * 自定义分页 属性&属性分组关联
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入attrAttrgroupRelation")
	public R<IPage<AttrAttrgroupRelationVO>> page(AttrAttrgroupRelationVO attrAttrgroupRelation, Query query) {
		IPage<AttrAttrgroupRelationVO> pages = attrAttrgroupRelationService.selectAttrAttrgroupRelationPage(Condition.getPage(query), attrAttrgroupRelation);
		return R.data(pages);
	}

	/**
	 * 新增 属性&属性分组关联
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入attrAttrgroupRelation")
	public R save(@Valid @RequestBody AttrAttrgroupRelation attrAttrgroupRelation) {
		return R.status(attrAttrgroupRelationService.save(attrAttrgroupRelation));
	}

	/**
	 * 修改 属性&属性分组关联
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入attrAttrgroupRelation")
	public R update(@Valid @RequestBody AttrAttrgroupRelation attrAttrgroupRelation) {
		return R.status(attrAttrgroupRelationService.updateById(attrAttrgroupRelation));
	}

	/**
	 * 新增或修改 属性&属性分组关联
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入attrAttrgroupRelation")
	public R submit(@Valid @RequestBody AttrAttrgroupRelation attrAttrgroupRelation) {
		return R.status(attrAttrgroupRelationService.saveOrUpdate(attrAttrgroupRelation));
	}

	
	/**
	 * 删除 属性&属性分组关联
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(attrAttrgroupRelationService.removeByIds(Func.toLongList(ids)));
	}

	
}
