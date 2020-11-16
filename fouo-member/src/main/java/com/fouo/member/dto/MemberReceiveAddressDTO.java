package com.fouo.member.dto;

import com.fouo.member.entity.MemberReceiveAddress;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 会员收货地址数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MemberReceiveAddressDTO extends MemberReceiveAddress {
	private static final long serialVersionUID = 1L;

}
