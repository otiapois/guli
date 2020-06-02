package com.fouo.member.service.impl;

import com.fouo.member.entity.Member;
import com.fouo.member.vo.MemberVO;
import com.fouo.member.mapper.MemberMapper;
import com.fouo.member.service.IMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 会员 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

	@Override
	public IPage<MemberVO> selectMemberPage(IPage<MemberVO> page, MemberVO member) {
		return page.setRecords(baseMapper.selectMemberPage(page, member));
	}

}
