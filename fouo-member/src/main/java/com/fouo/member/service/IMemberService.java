package com.fouo.member.service;

import com.fouo.member.entity.Member;
import com.fouo.member.vo.MemberVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

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

}
