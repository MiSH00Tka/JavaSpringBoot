package org.example.homework9.components;

import org.example.homework9.config.RabbitConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.homework9.dto.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(Message message) {
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, RabbitConfig.ROUTING_KEY_IN, message);
        log.info("Опубликовано сообщение: " + message);
    }
}
