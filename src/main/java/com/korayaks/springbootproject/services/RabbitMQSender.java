package com.korayaks.springbootproject.services;

import com.korayaks.springbootproject.entity.User;

public interface RabbitMQSender {
    void send(User user);
}
