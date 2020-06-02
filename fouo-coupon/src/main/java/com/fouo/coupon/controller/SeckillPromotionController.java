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
import com.fouo.coupon.entity.SeckillPromotion;
import com.fouo.coupon.vo.SeckillPromotionVO;
import com.fouo.coupon.service.ISeckillPromotionService;

/**
 * 秒杀活动 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/seckillpromotion")
@Api(value = "秒杀活动", tags = "秒杀活动接口")
public class SeckillPromotionController{

	private ISeckillPromotionService seckillPromotionService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入seckillPromotion")
	public R<SeckillPromotion> detail(SeckillPromotion seckillPromotion) {
		SeckillPromotion detail = seckillPromotionService.getOne(Condition.getQueryWrapper(seckillPromotion));
		return R.data(detail);
	}

	/**
	 * 分页 秒杀活动
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入seckillPromotion")
	public R<IPage<SeckillPromotion>> list(SeckillPromotion seckillPromotion, Query query) {
		IPage<SeckillPromotion> pages = seckillPromotionService.page(Condition.getPage(query), Condition.getQueryWrapper(seckillPromotion));
		return R.data(pages);
	}

	/**
	 * 自定义分页 秒杀活动
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入seckillPromotion")
	public R<IPage<SeckillPromotionVO>> page(SeckillPromotionVO seckillPromotion, Query query) {
		IPage<SeckillPromotionVO> pages = seckillPromotionService.selectSeckillPromotionPage(Condition.getPage(query), seckillPromotion);
		return R.data(pages);
	}

	/**
	 * 新增 秒杀活动
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入seckillPromotion")
	public R save(@Valid @RequestBody SeckillPromotion seckillPromotion) {
		return R.status(seckillPromotionService.save(seckillPromotion));
	}

	/**
	 * 修改 秒杀活动
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入seckillPromotion")
	public R update(@Valid @RequestBody SeckillPromotion seckillPromotion) {
		return R.status(seckillPromotionService.updateById(seckillPromotion));
	}

	/**
	 * 新增或修改 秒杀活动
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入seckillPromotion")
	public R submit(@Valid @RequestBody SeckillPromotion seckillPromotion) {
		return R.status(seckillPromotionService.saveOrUpdate(seckillPromotion));
	}

	
	/**
	 * 删除 秒杀活动
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(seckillPromotionService.removeByIds(Func.toLongList(ids)));
	}

	
}
