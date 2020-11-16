package com.fouo.order.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单确认页面实体数据
 *
 * @author fouo
 * @date 2020/9/11 11:04
 */
@Data
public class OrderConfirmVO {
    //收货地址列表实体
    private List<MemberReceiveAddressVO> address;

    //所选中的购物项
    private List<CartItemVO> items;

    //优惠券 会员积分
    private Integer integration;

    //订单总额
    private BigDecimal total;
    //应付总额
    private BigDecimal payPrice;


}
