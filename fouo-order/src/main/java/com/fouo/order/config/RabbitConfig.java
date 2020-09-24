package com.fouo.order.config;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * rabbitmq配置类
 *
 * @author fouo
 * @date 2020/9/9 9:34
 */
@Configuration
public class RabbitConfig {

    /**
     * 定制RabbitTemplate
     *
     * @PostConstruct 对象创建完之后执行该方法，执行这个方法
     */
    @PostConstruct
    public void iniRabbitTemplate() {
        /*
            发送端的消息回调
         */
        //设置确认回调（第一步）
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /**
             * 1.只要消息成功抵达消息服务器（broker代理） ack的值就位true
             * @param correlationData 当前消息（Message）的唯一关联数据
             * @param ack 消息是否成功收到
             * @param cause 消息获取失败的原因
             */
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//                System.out.println("correlationData：" + correlationData);
//                System.out.println("ack:" + ack);
//                System.out.println("cause:" + cause);
            }
        });

        //消息抵达队列的确认回调
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            /**
             * 只要消息没有投递给指定的队列，就触发这个失败回调
             * @param message 投递失败的消息详细信息
             * @param replyCode 回复的状态码
             * @param replyText 回复的文本内容
             * @param exchange  当时这个消息发给哪个交换机
             * @param routingKey 当时这个消息用的哪个路由键
             */
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("message:" + message);
                System.out.println("replyCode:" + replyCode);
                System.out.println("replyText:" + replyText);
                System.out.println("exchange:" + exchange);
                System.out.println("routingKey:" + routingKey);
            }
        });
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 对象序列化成json格式的配置
     *
     * @return
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}