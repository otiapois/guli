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
import com.fouo.coupon.entity.SeckillSkuRelation;
import com.fouo.coupon.vo.SeckillSkuRelationVO;
import com.fouo.coupon.service.ISeckillSkuRelationService;

/**
 * 秒杀活动商品关联 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/seckillskurelation")
@Api(value = "秒杀活动商品关联", tags = "秒杀活动商品关联接口")
public class SeckillSkuRelationController  {

	private ISeckillSkuRelationService seckillSkuRelationService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入seckillSkuRelation")
	public R<SeckillSkuRelation> detail(SeckillSkuRelation seckillSkuRelation) {
		SeckillSkuRelation detail = seckillSkuRelationService.getOne(Condition.getQueryWrapper(seckillSkuRelation));
		return R.data(detail);
	}

	/**
	 * 分页 秒杀活动商品关联
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入seckillSkuRelation")
	public R<IPage<SeckillSkuRelation>> list(SeckillSkuRelation seckillSkuRelation, Query query) {
		IPage<SeckillSkuRelation> pages = seckillSkuRelationService.page(Condition.getPage(query), Condition.getQueryWrapper(seckillSkuRelation));
		return R.data(pages);
	}

	/**
	 * 自定义分页 秒杀活动商品关联
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入seckillSkuRelation")
	public R<IPage<SeckillSkuRelationVO>> page(SeckillSkuRelationVO seckillSkuRelation, Query query) {
		IPage<SeckillSkuRelationVO> pages = seckillSkuRelationService.selectSeckillSkuRelationPage(Condition.getPage(query), seckillSkuRelation);
		return R.data(pages);
	}

	/**
	 * 新增 秒杀活动商品关联
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入seckillSkuRelation")
	public R save(@Valid @RequestBody SeckillSkuRelation seckillSkuRelation) {
		return R.status(seckillSkuRelationService.save(seckillSkuRelation));
	}

	/**
	 * 修改 秒杀活动商品关联
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入seckillSkuRelation")
	public R update(@Valid @RequestBody SeckillSkuRelation seckillSkuRelation) {
		return R.status(seckillSkuRelationService.updateById(seckillSkuRelation));
	}

	/**
	 * 新增或修改 秒杀活动商品关联
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入seckillSkuRelation")
	public R submit(@Valid @RequestBody SeckillSkuRelation seckillSkuRelation) {
		return R.status(seckillSkuRelationService.saveOrUpdate(seckillSkuRelation));
	}

	
	/**
	 * 删除 秒杀活动商品关联
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(seckillSkuRelationService.removeByIds(Func.toLongList(ids)));
	}

	
}
