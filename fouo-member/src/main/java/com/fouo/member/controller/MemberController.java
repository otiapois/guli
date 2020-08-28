package com.fouo.member.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.common.support.Condition;
import com.fouo.common.support.Query;
import com.fouo.common.support.R;
import com.fouo.common.utils.Func;
import com.fouo.coupon.entity.Coupon;
import com.fouo.member.entity.Member;
import com.fouo.member.exception.MobileExistException;
import com.fouo.member.exception.UsernameExistException;
import com.fouo.member.service.IMemberService;
import com.fouo.member.vo.MemberRegistVO;
import com.fouo.member.vo.MemberVO;
import com.fouo.member.vo.SocialUserVO;
import com.fouo.member.vo.UserLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 会员 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/member/member")
@Api(value = "会员", tags = "会员接口")
public class MemberController {

    private IMemberService memberService;


    /**
     * 详情
     */
    @GetMapping("/detail")
    @ApiOperation(value = "详情", notes = "传入member")
    public R<Member> detail(Member member) {
        Member detail = memberService.getOne(Condition.getQueryWrapper(member));
        return R.data(detail);
    }

    /**
     * 分页 会员
     */
    @GetMapping("/list")
    @ApiOperation(value = "分页", notes = "传入member")
    public R<IPage<Member>> list(Member member, Query query) {
        IPage<Member> pages = memberService.page(Condition.getPage(query), Condition.getQueryWrapper(member));
        return R.data(pages);
    }

    /**
     * 自定义分页 会员
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页", notes = "传入member")
    public R<IPage<MemberVO>> page(MemberVO member, Query query) {
        IPage<MemberVO> pages = memberService.selectMemberPage(Condition.getPage(query), member);
        return R.data(pages);
    }

    /**
     * 新增 会员
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增", notes = "传入member")
    public R save(@Valid @RequestBody Member member) {
        return R.status(memberService.save(member));
    }

    /**
     * 注册会员
     */
    @PostMapping("/regist")
    @ApiOperation(value = "注册", notes = "传入MemberRegistVO")
    public R regist(@RequestBody MemberRegistVO memberRegistVO) {
        try {
            memberService.regist(memberRegistVO);
        } catch (MobileExistException e) {
            return R.fail("手机号已注册");
        } catch (UsernameExistException e) {
            return R.fail("用户已存在");
        }
        return R.status(true);
    }

    /**
     * 修改 会员
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改", notes = "传入member")
    public R update(@Valid @RequestBody Member member) {
        return R.status(memberService.updateById(member));
    }

    /**
     * 新增或修改 会员
     */
    @PostMapping("/submit")
    @ApiOperation(value = "新增或修改", notes = "传入member")
    public R submit(@Valid @RequestBody Member member) {
        return R.status(memberService.saveOrUpdate(member));
    }


    /**
     * 删除 会员
     */
    @PostMapping("/remove")
    @ApiOperation(value = "删除", notes = "传入ids")
    public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
        return R.status(memberService.removeByIds(Func.toLongList(ids)));
    }

    /**
     * 社交登录
     *
     * @return
     */
    @PostMapping("/oauth2/login")
    @ApiOperation(value = "社交登录", notes = "传入社交用户信息")
    public R<Member> socialLogin(@RequestBody SocialUserVO socialUserVO) {

        Member member = memberService.socialLogin(socialUserVO);
        if (member != null) {
            return R.data(member);
        } else {
            return R.fail("账号密码错误");
        }
    }

    /**
     * 会员登录
     *
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "登录", notes = "传入登录信息")
    public R<Member> login(@RequestBody UserLoginVO userLoginVO) {

        Member member = memberService.login(userLoginVO);
        if (member != null) {
            return R.data(member);
        } else {
            return R.fail("账号密码错误");
        }

    }

}
