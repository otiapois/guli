package com.fouo.member.mapper;

import com.fouo.member.entity.MemberReceiveAddress;
import com.fouo.member.vo.MemberReceiveAddressVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 会员收货地址 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface MemberReceiveAddressMapper extends BaseMapper<MemberReceiveAddress> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param memberReceiveAddress
	 * @return
	 */
	List<MemberReceiveAddressVO> selectMemberReceiveAddressPage(IPage page, MemberReceiveAddressVO memberReceiveAddress);

}
