package com.fouo.member.mapper;

import com.fouo.member.entity.Member;
import com.fouo.member.vo.MemberVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 会员 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface MemberMapper extends BaseMapper<Member> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param member
	 * @return
	 */
	List<MemberVO> selectMemberPage(IPage page, MemberVO member);

}
