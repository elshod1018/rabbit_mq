package com.company.consumer;

import com.company.dto.UserCreateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQJsonConsumer {
    @RabbitListener(queues = "${rabbitmq.json.queue.name}")
    public void consumeJsonMessage(UserCreateDTO dto) {
        log.info("Json message received: {}", dto.toString());
    }
}
