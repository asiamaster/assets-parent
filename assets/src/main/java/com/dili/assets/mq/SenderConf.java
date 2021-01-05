package com.dili.assets.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConf {

    @Bean(name = "message")
    public Queue queueMessage() {
        return new Queue("assets.update");
    }

    @Bean(name = "messages")
    public Queue queueMessages() {
        return new Queue("area.update");
    }

    @Bean(name = "messagesDelete")
    public Queue queueMessagesDelete() {
        return new Queue("assets.delete");
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }
}
