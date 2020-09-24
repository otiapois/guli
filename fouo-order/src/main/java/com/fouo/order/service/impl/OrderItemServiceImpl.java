package com.fouo.order.service.impl;

import com.fouo.order.entity.Order;
import com.fouo.order.entity.OrderItem;
import com.fouo.order.vo.OrderItemVO;
import com.fouo.order.mapper.OrderItemMapper;
import com.fouo.order.service.IOrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rabbitmq.client.Channel;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.io.IOException;

/**
 * 订单项信息 服务实现类
 *
 * 	@GlobalTransactional 开启全局分布式事务
 * @author fouo
 * @since 2020-06-02
 */
@Service
@RabbitListener(queues = {"fouo-queue"})
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements IOrderItemService {

	@Override
	public IPage<OrderItemVO> selectOrderItemPage(IPage<OrderItemVO> page, OrderItemVO orderItem) {
		return page.setRecords(baseMapper.selectOrderItemPage(page, orderItem));
	}


	/**
	 * 监听器
	 * 监听并消费消息队列中获取的消息
	 * @param message
	 * Message message: 消息的总体情况 （包括消息头和消息体）
	 * Order order: 第二个参数是返回对象的类型
	 * Channel channel: 数据传输的通道
	 * Queue可以由被多个方面同时监听，只要收到消息，队列中就会清除该消息
	 *
	 * @RabbitListener 标注在类上面表示当有收到消息的时候，
	 * 就交给 @RabbitHandler 的方法处理，具体使用哪个方法处理，根据 MessageConverter 转换后的参数类型
	 * 用于重载区分不同的消息
	 */
//	@RabbitListener(queues = {"fouo-queue"})
	@RabbitHandler
	@GlobalTransactional
	public void receiveMessage(Message message, Order order, Channel channel) {
		System.out.println(message);
		System.out.println(order);
		System.out.println(channel);

		long deliveryTag = message.getMessageProperties().getDeliveryTag();

		try{
			//消息签收，false非批量模式
			channel.basicAck(deliveryTag,false);
		}catch (Exception e){
//			try {
//				//requue = false  将消息丢弃   =true 发回服务器 服务器重新入队列
//				channel.basicNack(deliveryTag,false,true);
//			} catch (IOException ex) {
//				ex.printStackTrace();
//			}
			//网路中断
			e.printStackTrace();
		}

	}
}
