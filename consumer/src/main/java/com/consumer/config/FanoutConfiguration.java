package com.consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfiguration {
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("njnuqy.fanout2");
    }

    @Bean
    public Queue fanoutQueue3(){
        return new Queue("fanout.queue3");
    }

    @Bean
    public Binding fanoutBinding3(){
        return BindingBuilder.bind(fanoutQueue3()).to(fanoutExchange());
    }
}
