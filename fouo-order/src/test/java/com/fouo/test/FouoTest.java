package com.fouo.test;


import com.fouo.order.OrderApplication;
import com.fouo.order.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * rabbitmq 测试
 *
 * @author fouo
 * @date 2020/9/9 9:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class)
public class FouoTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    /**
     * 查看接口实现类 快捷键  ctrl+ alt + b
     * 创建 Exchange、Queue、Binding
     */
    @Test
    public void createExchange() {
        //创建交换机
        TopicExchange exchange = new TopicExchange("fouo-exchange", true, false);
        amqpAdmin.declareExchange(exchange);
    }

    @Test
    public void createQueue() {
        Queue queue = new Queue("fouo-queue", true, false, false);
        //创建Rabbitmq队列
        amqpAdmin.declareQueue(queue);
    }

    @Test
    public void createBinding() {
        //创建绑定
        Binding binding = new Binding("fouo-queue", Binding.DestinationType.QUEUE, "fouo-exchange", "fouo.routingKey", null);
        amqpAdmin.declareBinding(binding);
    }

    @Test
    public void testSendMessage() {
        Order order = new Order();
        order.setId(1L);
        order.setReceiverName("测试名称");
        rabbitTemplate.convertAndSend("fouo-exchange", "fouo.routingKey", order);
    }

}
