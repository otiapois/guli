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
import com.fouo.coupon.entity.SeckillSession;
import com.fouo.coupon.vo.SeckillSessionVO;
import com.fouo.coupon.service.ISeckillSessionService;

/**
 * 秒杀活动场次 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/seckillsession")
@Api(value = "秒杀活动场次", tags = "秒杀活动场次接口")
public class SeckillSessionController {

	private ISeckillSessionService seckillSessionService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入seckillSession")
	public R<SeckillSession> detail(SeckillSession seckillSession) {
		SeckillSession detail = seckillSessionService.getOne(Condition.getQueryWrapper(seckillSession));
		return R.data(detail);
	}

	/**
	 * 分页 秒杀活动场次
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入seckillSession")
	public R<IPage<SeckillSession>> list(SeckillSession seckillSession, Query query) {
		IPage<SeckillSession> pages = seckillSessionService.page(Condition.getPage(query), Condition.getQueryWrapper(seckillSession));
		return R.data(pages);
	}

	/**
	 * 自定义分页 秒杀活动场次
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入seckillSession")
	public R<IPage<SeckillSessionVO>> page(SeckillSessionVO seckillSession, Query query) {
		IPage<SeckillSessionVO> pages = seckillSessionService.selectSeckillSessionPage(Condition.getPage(query), seckillSession);
		return R.data(pages);
	}

	/**
	 * 新增 秒杀活动场次
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入seckillSession")
	public R save(@Valid @RequestBody SeckillSession seckillSession) {
		return R.status(seckillSessionService.save(seckillSession));
	}

	/**
	 * 修改 秒杀活动场次
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入seckillSession")
	public R update(@Valid @RequestBody SeckillSession seckillSession) {
		return R.status(seckillSessionService.updateById(seckillSession));
	}

	/**
	 * 新增或修改 秒杀活动场次
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入seckillSession")
	public R submit(@Valid @RequestBody SeckillSession seckillSession) {
		return R.status(seckillSessionService.saveOrUpdate(seckillSession));
	}

	
	/**
	 * 删除 秒杀活动场次
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(seckillSessionService.removeByIds(Func.toLongList(ids)));
	}

	
}
