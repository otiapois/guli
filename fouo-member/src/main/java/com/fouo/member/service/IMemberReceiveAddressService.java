package com.fouo.member.service;

import com.fouo.member.entity.MemberReceiveAddress;
import com.fouo.member.vo.MemberReceiveAddressVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * 会员收货地址 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IMemberReceiveAddressService extends IService<MemberReceiveAddress> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param memberReceiveAddress
	 * @return
	 */
	IPage<MemberReceiveAddressVO> selectMemberReceiveAddressPage(IPage<MemberReceiveAddressVO> page, MemberReceiveAddressVO memberReceiveAddress);

	/**
	 * 根据会员id获取会员的收获地址列表
	 * @param memberId
	 * @return
	 */
    List<MemberReceiveAddress> getAddress(Long memberId);
}
