package com.fouo.member.controller;

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
import com.fouo.member.entity.MemberReceiveAddress;
import com.fouo.member.vo.MemberReceiveAddressVO;
import com.fouo.member.service.IMemberReceiveAddressService;

/**
 * 会员收货地址 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/member/memberreceiveaddress")
@Api(value = "会员收货地址", tags = "会员收货地址接口")
public class MemberReceiveAddressController {

	private IMemberReceiveAddressService memberReceiveAddressService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入memberReceiveAddress")
	public R<MemberReceiveAddress> detail(MemberReceiveAddress memberReceiveAddress) {
		MemberReceiveAddress detail = memberReceiveAddressService.getOne(Condition.getQueryWrapper(memberReceiveAddress));
		return R.data(detail);
	}

	/**
	 * 分页 会员收货地址
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入memberReceiveAddress")
	public R<IPage<MemberReceiveAddress>> list(MemberReceiveAddress memberReceiveAddress, Query query) {
		IPage<MemberReceiveAddress> pages = memberReceiveAddressService.page(Condition.getPage(query), Condition.getQueryWrapper(memberReceiveAddress));
		return R.data(pages);
	}

	/**
	 * 自定义分页 会员收货地址
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入memberReceiveAddress")
	public R<IPage<MemberReceiveAddressVO>> page(MemberReceiveAddressVO memberReceiveAddress, Query query) {
		IPage<MemberReceiveAddressVO> pages = memberReceiveAddressService.selectMemberReceiveAddressPage(Condition.getPage(query), memberReceiveAddress);
		return R.data(pages);
	}

	/**
	 * 新增 会员收货地址
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入memberReceiveAddress")
	public R save(@Valid @RequestBody MemberReceiveAddress memberReceiveAddress) {
		return R.status(memberReceiveAddressService.save(memberReceiveAddress));
	}

	/**
	 * 修改 会员收货地址
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入memberReceiveAddress")
	public R update(@Valid @RequestBody MemberReceiveAddress memberReceiveAddress) {
		return R.status(memberReceiveAddressService.updateById(memberReceiveAddress));
	}

	/**
	 * 新增或修改 会员收货地址
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入memberReceiveAddress")
	public R submit(@Valid @RequestBody MemberReceiveAddress memberReceiveAddress) {
		return R.status(memberReceiveAddressService.saveOrUpdate(memberReceiveAddress));
	}

	
	/**
	 * 删除 会员收货地址
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(memberReceiveAddressService.removeByIds(Func.toLongList(ids)));
	}

	
}
