package com.flyfish.queue;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @autohr flyfish
 * @date: 2023/1/17 23:32
 * @description:
 */
@Component
public class ConsumeA {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "boot-topic",type = "topic"),
            key = {"#"}
    ))
    public void consume(Message message){
        System.out.println("1收到消息:"+new String(message.getBody()));
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "boot-topic",type = "topic"),
            key = {"bjwlxy.jsj.*"}
    ))
    public void consume2(Message message){
        System.out.println("2收到消息:"+new String(message.getBody()));
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "boot-topic",type = "topic"),
            key = {"bjwlxy.jsj.awo"}
    ))
    public void consume3(Message message){
        System.out.println("3收到消息:"+new String(message.getBody()));
    }
}
