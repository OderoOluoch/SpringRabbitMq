package com.odero.springrabbitmq.consumer;

import com.odero.springrabbitmq.config.MessagingConfig;
import com.odero.springrabbitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus){
        System.out.println("Message Received from queue :" + orderStatus);

    }
}
