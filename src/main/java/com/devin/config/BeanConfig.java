package com.devin.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 * @author: simpl
 * @date: 2020/2/25
 * @time: 17:25
 * @description: 
 */


@SpringBootConfiguration
public class BeanConfig {


    @Bean
    public MessageSendingOperations messagingTemplate() {
        return new SimpMessagingTemplate(new MessageChannel() {
            @Override
            public boolean send(Message<?> message, long l) {
                return true;
            }
        });
    }
}
