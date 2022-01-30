package com.korayaks.springbootproject.services.impl;

import com.korayaks.springbootproject.entity.User;
import com.korayaks.springbootproject.services.RabbitMQSender;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSenderImpl implements RabbitMQSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${korayaks.rabbitmq.exchange}")
    private String exchange;

    @Value("${korayaks.rabbitmq.routingkey}")
    private String routingkey;

    public void send(User user) {
        rabbitTemplate.convertAndSend(exchange, routingkey, user);
        System.out.println("Send msg = " + user);
    }
}
