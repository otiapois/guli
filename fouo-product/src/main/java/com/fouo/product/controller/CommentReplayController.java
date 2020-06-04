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
import com.fouo.product.entity.CommentReplay;
import com.fouo.product.vo.CommentReplayVO;
import com.fouo.product.service.ICommentReplayService;

/**
 * 商品评价回复关系 控制器
 *
 * @author fouo
 * @since 2020-06-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/commentreplay")
@Api(value = "商品评价回复关系", tags = "商品评价回复关系接口")
public class CommentReplayController {

	private ICommentReplayService commentReplayService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入commentReplay")
	public R<CommentReplay> detail(CommentReplay commentReplay) {
		CommentReplay detail = commentReplayService.getOne(Condition.getQueryWrapper(commentReplay));
		return R.data(detail);
	}

	/**
	 * 分页 商品评价回复关系
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入commentReplay")
	public R<IPage<CommentReplay>> list(CommentReplay commentReplay, Query query) {
		IPage<CommentReplay> pages = commentReplayService.page(Condition.getPage(query), Condition.getQueryWrapper(commentReplay));
		return R.data(pages);
	}

	/**
	 * 自定义分页 商品评价回复关系
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入commentReplay")
	public R<IPage<CommentReplayVO>> page(CommentReplayVO commentReplay, Query query) {
		IPage<CommentReplayVO> pages = commentReplayService.selectCommentReplayPage(Condition.getPage(query), commentReplay);
		return R.data(pages);
	}

	/**
	 * 新增 商品评价回复关系
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入commentReplay")
	public R save(@Valid @RequestBody CommentReplay commentReplay) {
		return R.status(commentReplayService.save(commentReplay));
	}

	/**
	 * 修改 商品评价回复关系
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入commentReplay")
	public R update(@Valid @RequestBody CommentReplay commentReplay) {
		return R.status(commentReplayService.updateById(commentReplay));
	}

	/**
	 * 新增或修改 商品评价回复关系
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入commentReplay")
	public R submit(@Valid @RequestBody CommentReplay commentReplay) {
		return R.status(commentReplayService.saveOrUpdate(commentReplay));
	}

	
	/**
	 * 删除 商品评价回复关系
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(commentReplayService.removeByIds(Func.toLongList(ids)));
	}

	
}
