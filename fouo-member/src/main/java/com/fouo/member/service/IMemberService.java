package com.fouo.member.service;

import com.fouo.member.entity.Member;
import com.fouo.member.exception.MobileExistException;
import com.fouo.member.exception.UsernameExistException;
import com.fouo.member.vo.MemberRegistVO;
import com.fouo.member.vo.MemberVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.member.vo.SocialUserVO;
import com.fouo.member.vo.UserLoginVO;

/**
 * 会员 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IMemberService extends IService<Member> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param member
	 * @return
	 */
	IPage<MemberVO> selectMemberPage(IPage<MemberVO> page, MemberVO member);

	/**
	 * 注册会员
	 * @param memberRegistVO
	 * @return
	 */
    boolean regist(MemberRegistVO memberRegistVO);

	/**
	 * 检测用户名是否唯一
	 * @param userName
	 * @return
	 */
	void checkUsernameUnique(String userName) throws UsernameExistException;

	/**
	 * 检测手机号是否唯一
	 * @param phone
	 * @return
	 */
	void checkMobileUnique(String phone) throws MobileExistException;

	/**
	 * 用户登录
	 * @param userLoginVO
	 * @return
	 */
    Member login(UserLoginVO userLoginVO);

	/**
	 * 社交用户登录
	 * @param socialUserVO
	 * @return
	 */
	Member socialLogin(SocialUserVO socialUserVO);
}
