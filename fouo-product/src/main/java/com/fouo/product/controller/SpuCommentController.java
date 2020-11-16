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
import com.fouo.product.entity.SpuComment;
import com.fouo.product.vo.SpuCommentVO;
import com.fouo.product.service.ISpuCommentService;

/**
 * 商品评价 控制器
 *
 * @author fouo
 * @since 2020-06-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/product/spucomment")
@Api(value = "商品评价", tags = "商品评价接口")
public class SpuCommentController {

	private ISpuCommentService spuCommentService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入spuComment")
	public R<SpuComment> detail(SpuComment spuComment) {
		SpuComment detail = spuCommentService.getOne(Condition.getQueryWrapper(spuComment));
		return R.data(detail);
	}

	/**
	 * 分页 商品评价
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入spuComment")
	public R<IPage<SpuComment>> list(SpuComment spuComment, Query query) {
		IPage<SpuComment> pages = spuCommentService.page(Condition.getPage(query), Condition.getQueryWrapper(spuComment));
		return R.data(pages);
	}

	/**
	 * 自定义分页 商品评价
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入spuComment")
	public R<IPage<SpuCommentVO>> page(SpuCommentVO spuComment, Query query) {
		IPage<SpuCommentVO> pages = spuCommentService.selectSpuCommentPage(Condition.getPage(query), spuComment);
		return R.data(pages);
	}

	/**
	 * 新增 商品评价
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入spuComment")
	public R save(@Valid @RequestBody SpuComment spuComment) {
		return R.status(spuCommentService.save(spuComment));
	}

	/**
	 * 修改 商品评价
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入spuComment")
	public R update(@Valid @RequestBody SpuComment spuComment) {
		return R.status(spuCommentService.updateById(spuComment));
	}

	/**
	 * 新增或修改 商品评价
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入spuComment")
	public R submit(@Valid @RequestBody SpuComment spuComment) {
		return R.status(spuCommentService.saveOrUpdate(spuComment));
	}

	
	/**
	 * 删除 商品评价
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(spuCommentService.removeByIds(Func.toLongList(ids)));
	}

	
}
