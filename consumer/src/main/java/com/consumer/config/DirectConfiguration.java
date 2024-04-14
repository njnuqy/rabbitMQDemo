package com.consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfiguration {

    @Bean
    public DirectExchange directExchange1(){
        return new DirectExchange("njnuqy.exchange");
    }

    @Bean
    public Queue directQueue1(){
        return new Queue("direct.queue1");
    }


}
