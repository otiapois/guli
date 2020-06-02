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
import com.fouo.coupon.entity.SeckillSkuNotice;
import com.fouo.coupon.vo.SeckillSkuNoticeVO;
import com.fouo.coupon.service.ISeckillSkuNoticeService;

/**
 * 秒杀商品通知订阅 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/seckillskunotice")
@Api(value = "秒杀商品通知订阅", tags = "秒杀商品通知订阅接口")
public class SeckillSkuNoticeController {

	private ISeckillSkuNoticeService seckillSkuNoticeService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入seckillSkuNotice")
	public R<SeckillSkuNotice> detail(SeckillSkuNotice seckillSkuNotice) {
		SeckillSkuNotice detail = seckillSkuNoticeService.getOne(Condition.getQueryWrapper(seckillSkuNotice));
		return R.data(detail);
	}

	/**
	 * 分页 秒杀商品通知订阅
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入seckillSkuNotice")
	public R<IPage<SeckillSkuNotice>> list(SeckillSkuNotice seckillSkuNotice, Query query) {
		IPage<SeckillSkuNotice> pages = seckillSkuNoticeService.page(Condition.getPage(query), Condition.getQueryWrapper(seckillSkuNotice));
		return R.data(pages);
	}

	/**
	 * 自定义分页 秒杀商品通知订阅
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入seckillSkuNotice")
	public R<IPage<SeckillSkuNoticeVO>> page(SeckillSkuNoticeVO seckillSkuNotice, Query query) {
		IPage<SeckillSkuNoticeVO> pages = seckillSkuNoticeService.selectSeckillSkuNoticePage(Condition.getPage(query), seckillSkuNotice);
		return R.data(pages);
	}

	/**
	 * 新增 秒杀商品通知订阅
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入seckillSkuNotice")
	public R save(@Valid @RequestBody SeckillSkuNotice seckillSkuNotice) {
		return R.status(seckillSkuNoticeService.save(seckillSkuNotice));
	}

	/**
	 * 修改 秒杀商品通知订阅
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入seckillSkuNotice")
	public R update(@Valid @RequestBody SeckillSkuNotice seckillSkuNotice) {
		return R.status(seckillSkuNoticeService.updateById(seckillSkuNotice));
	}

	/**
	 * 新增或修改 秒杀商品通知订阅
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入seckillSkuNotice")
	public R submit(@Valid @RequestBody SeckillSkuNotice seckillSkuNotice) {
		return R.status(seckillSkuNoticeService.saveOrUpdate(seckillSkuNotice));
	}

	
	/**
	 * 删除 秒杀商品通知订阅
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(seckillSkuNoticeService.removeByIds(Func.toLongList(ids)));
	}

	
}
