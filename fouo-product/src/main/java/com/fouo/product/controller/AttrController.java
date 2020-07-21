package com.fouo.product.controller;

import com.fouo.common.support.Condition;
import com.fouo.common.support.Query;
import com.fouo.common.support.R;
import com.fouo.common.utils.Func;
import com.fouo.product.vo.BrandVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.product.entity.Attr;
import com.fouo.product.vo.AttrVO;
import com.fouo.product.service.IAttrService;

import java.util.Arrays;

/**
 * 商品属性 控制器
 *
 * @author fouo
 * @since 2020-06-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/product/attr")
@Api(value = "商品属性", tags = "商品属性接口")
public class AttrController {

	private IAttrService attrService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入attr")
	public R<Attr> detail(Attr attr) {
//		Attr detail = attrService.getOne(Condition.getQueryWrapper(attr));
		AttrVO attrVO = attrService.getDetail(attr.getAttrId());
		return R.data(attrVO);
	}

	/**
	 * 分页
	 * 商品基本属性
	 */
	@GetMapping("/base/list")
	@ApiOperation(value = "分页", notes = "传入attr")
	public R<IPage<AttrVO>> getBaseList(AttrVO attrVO, Query query) {
		//去除关键词的空格
		if (StringUtils.isBlank(attrVO.getSearchKeyword())) {
			attrVO.setSearchKeyword(null);
		}
		IPage<AttrVO> pages = attrService.selectBaseAttrPage(Condition.getPage(query), attrVO);
		return R.data(pages);
	}

	/**
	 * 分页
	 * 商品销售属性
	 */
	@GetMapping("/sale/list")
	@ApiOperation(value = "分页", notes = "传入attr")
	public R<IPage<AttrVO>> getSaleList(AttrVO attrVO, Query query) {
		//去除关键词的空格
		if (StringUtils.isBlank(attrVO.getSearchKeyword())) {
			attrVO.setSearchKeyword(null);
		}
		IPage<AttrVO> pages = attrService.selectSaleAttrPage(Condition.getPage(query), attrVO);
		return R.data(pages);
	}
	/**
	 * 分页 商品属性
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入attr")
	public R<IPage<AttrVO>> list(AttrVO attrVO, Query query) {
		//去除关键词的空格
		if (StringUtils.isBlank(attrVO.getSearchKeyword())) {
			attrVO.setSearchKeyword(null);
		}
		IPage<AttrVO> pages = attrService.selectAttrPage(Condition.getPage(query), attrVO);
		return R.data(pages);
	}

	/**
	 * 自定义分页 商品属性
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入attr")
	public R<IPage<AttrVO>> page(AttrVO attr, Query query) {
		IPage<AttrVO> pages = attrService.selectAttrPage(Condition.getPage(query), attr);
		return R.data(pages);
	}

	/**
	 * 新增 商品属性
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入attr")
	public R save(@Valid @RequestBody AttrVO attrVO) {
		return R.status(attrService.saveAttr(attrVO));
	}

	/**
	 * 修改 商品属性
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入attr")
	public R update(@Valid @RequestBody AttrVO attrVO) {
		return R.status(attrService.updateAttr(attrVO));
	}

	/**
	 * 新增或修改 商品属性
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入attr")
	public R submit(@Valid @RequestBody Attr attr) {
		return R.status(attrService.saveOrUpdate(attr));
	}

	
	/**
	 * 删除 商品属性
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody Long[] ids) {
		return R.status(attrService.removeByIds(Arrays.asList(ids)));
	}

}
