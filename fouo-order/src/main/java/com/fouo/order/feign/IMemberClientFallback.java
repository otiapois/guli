package com.fouo.order.feign;

import com.fouo.order.vo.MemberReceiveAddressVO;

import java.util.List;

public class IMemberClientFallback implements IMemberClient{

    @Override
    public List<MemberReceiveAddressVO> getAddress(Long memberId) {
        return null;
    }
}
