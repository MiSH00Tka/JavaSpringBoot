package org.example.homework9.components;

import org.example.homework9.config.RabbitConfig;
import lombok.extern.log4j.Log4j2;
import org.example.homework9.dto.Response;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class MessageReceiver {
    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void receiveMessage(Response response) {
        log.info("Получено сообщение: " + response);
    }
}
