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
import com.fouo.product.entity.SpuImages;
import com.fouo.product.vo.SpuImagesVO;
import com.fouo.product.service.ISpuImagesService;

/**
 * spu图片 控制器
 *
 * @author fouo
 * @since 2020-06-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/product/spuimages")
@Api(value = "spu图片", tags = "spu图片接口")
public class SpuImagesController  {

	private ISpuImagesService spuImagesService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入spuImages")
	public R<SpuImages> detail(SpuImages spuImages) {
		SpuImages detail = spuImagesService.getOne(Condition.getQueryWrapper(spuImages));
		return R.data(detail);
	}

	/**
	 * 分页 spu图片
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入spuImages")
	public R<IPage<SpuImages>> list(SpuImages spuImages, Query query) {
		IPage<SpuImages> pages = spuImagesService.page(Condition.getPage(query), Condition.getQueryWrapper(spuImages));
		return R.data(pages);
	}

	/**
	 * 自定义分页 spu图片
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入spuImages")
	public R<IPage<SpuImagesVO>> page(SpuImagesVO spuImages, Query query) {
		IPage<SpuImagesVO> pages = spuImagesService.selectSpuImagesPage(Condition.getPage(query), spuImages);
		return R.data(pages);
	}

	/**
	 * 新增 spu图片
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入spuImages")
	public R save(@Valid @RequestBody SpuImages spuImages) {
		return R.status(spuImagesService.save(spuImages));
	}

	/**
	 * 修改 spu图片
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入spuImages")
	public R update(@Valid @RequestBody SpuImages spuImages) {
		return R.status(spuImagesService.updateById(spuImages));
	}

	/**
	 * 新增或修改 spu图片
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入spuImages")
	public R submit(@Valid @RequestBody SpuImages spuImages) {
		return R.status(spuImagesService.saveOrUpdate(spuImages));
	}

	
	/**
	 * 删除 spu图片
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(spuImagesService.removeByIds(Func.toLongList(ids)));
	}

	
}
