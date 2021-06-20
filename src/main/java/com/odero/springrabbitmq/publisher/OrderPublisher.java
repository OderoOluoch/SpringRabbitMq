package com.odero.springrabbitmq.publisher;

import com.odero.springrabbitmq.config.MessagingConfig;
import com.odero.springrabbitmq.dto.Order;
import com.odero.springrabbitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order,@PathVariable String restaurantName){
        order.setOrderId(UUID.randomUUID().toString());
        //Order goes to the restaurant service
        //Order goes to the payment service
        //So because we do not want out client to wait this long, we give feedback
        OrderStatus orderStatus = new OrderStatus(order,"PROCESSING","Order placed successfully in "+ restaurantName);
        template.convertAndSend(MessagingConfig.EXCHANGE,MessagingConfig.ROUTING_KEY,orderStatus);

        return "Success !!";
    }
}
