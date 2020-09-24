package com.fouo.order.service.impl;

import com.fouo.order.entity.Order;
import com.fouo.order.feign.IMemberClient;
import com.fouo.order.interceptor.LoginUserInterceptor;
import com.fouo.order.vo.MemberReceiveAddressVO;
import com.fouo.order.vo.OrderConfirmVO;
import com.fouo.order.vo.OrderVO;
import com.fouo.order.mapper.OrderMapper;
import com.fouo.order.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * 订单 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Autowired
    private IMemberClient iMemberClient;

    @Override
    public IPage<OrderVO> selectOrderPage(IPage<OrderVO> page, OrderVO order) {
        return page.setRecords(baseMapper.selectOrderPage(page, order));
    }

    @Override
    public OrderConfirmVO confirmOrder() {
        OrderConfirmVO confirmVO = new OrderConfirmVO();

        //远程查询所有的收获地址列表
        List<MemberReceiveAddressVO> address = iMemberClient.getAddress(LoginUserInterceptor.threadLocal.get().getId());
        confirmVO.setAddress(address);

        //远程查购物车所有选中的购物项


        return null;
    }

}
