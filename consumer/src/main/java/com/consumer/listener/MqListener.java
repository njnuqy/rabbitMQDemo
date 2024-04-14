package com.consumer.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MqListener {
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue(String msg){
        System.out.println(msg);
    }

    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue1(String msg) throws InterruptedException {
        System.out.println("消费者1收到了workqueue的消息" + msg);
        Thread.sleep(200);
    }
    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue2(String msg) throws InterruptedException {
        System.err.println("消费者2收到了workqueue的消息" + msg);
        Thread.sleep(20);
    }

    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueue1(String msg) throws InterruptedException {
        System.out.println("消费者1收到了fanout的消息" + msg);
        Thread.sleep(200);
    }
    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueue2(String msg) throws InterruptedException {
        System.out.println("消费者2收到了fanout的消息" + msg);
        Thread.sleep(20);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1",durable = "true"),
            exchange = @Exchange(name = "njnuqy.direct",type = ExchangeTypes.DIRECT),
            key = {"red","blue"}
    ))
    public void listenDirectQueue1(String msg) throws InterruptedException {
        System.out.println("消费者1收到了dirent的消息" + msg);
        Thread.sleep(200);
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2",durable = "true"),
            exchange = @Exchange(name = "njnuqy.direct",type = ExchangeTypes.DIRECT),
            key = {"red","yellow"}
    ))
    public void listenDirectQueue2(String msg) throws InterruptedException {
        System.out.println("消费者2收到了dirent的消息" + msg);
        Thread.sleep(20);
    }

    @RabbitListener(queues = "topic.queue1")
    public void listenTopicQueue1(String msg) throws InterruptedException {
        System.out.println("消费者1收到了topic的消息" + msg);
        Thread.sleep(200);
    }
    @RabbitListener(queues = "topic.queue2")
    public void listenTopicQueue2(String msg) throws InterruptedException {
        System.out.println("消费者2收到了topic的消息" + msg);
        Thread.sleep(20);
    }

    @RabbitListener(queues = "object.queue")
    public void listenObjectQueue(Map<String,Object> msg) throws InterruptedException {
        System.out.println("消费者2收到了topic的消息" + msg);
        Thread.sleep(20);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "delay.queue",durable = "true"),
            exchange = @Exchange(value = "delay.direct",delayed = "true"),
            key = "hi"
    ))
    public void listenDelayQueue(String msg){
        System.out.println("接收到delay的消息");
    }
}
