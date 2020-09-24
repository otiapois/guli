package com.fouo.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fouo.member.entity.MemberReceiveAddress;
import com.fouo.member.vo.MemberReceiveAddressVO;
import com.fouo.member.mapper.MemberReceiveAddressMapper;
import com.fouo.member.service.IMemberReceiveAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * 会员收货地址 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class MemberReceiveAddressServiceImpl extends ServiceImpl<MemberReceiveAddressMapper, MemberReceiveAddress> implements IMemberReceiveAddressService {

	@Override
	public IPage<MemberReceiveAddressVO> selectMemberReceiveAddressPage(IPage<MemberReceiveAddressVO> page, MemberReceiveAddressVO memberReceiveAddress) {
		return page.setRecords(baseMapper.selectMemberReceiveAddressPage(page, memberReceiveAddress));
	}

	@Override
	public List<MemberReceiveAddress> getAddress(Long memberId) {
		return baseMapper.selectList(new QueryWrapper<MemberReceiveAddress>().eq("member_id", memberId));
	}

}
