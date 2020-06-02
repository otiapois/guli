package com.fouo.member.service;

import com.fouo.member.entity.MemberReceiveAddress;
import com.fouo.member.vo.MemberReceiveAddressVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

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

}
