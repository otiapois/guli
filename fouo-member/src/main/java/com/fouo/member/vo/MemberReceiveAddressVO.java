package com.fouo.member.vo;

import com.fouo.member.entity.MemberReceiveAddress;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 会员收货地址视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "MemberReceiveAddressVO对象", description = "会员收货地址")
public class MemberReceiveAddressVO extends MemberReceiveAddress {
	private static final long serialVersionUID = 1L;

}
