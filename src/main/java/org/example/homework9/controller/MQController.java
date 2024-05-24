package org.example.homework9.controller;

import org.example.homework9.components.MessageSender;
import lombok.RequiredArgsConstructor;
import org.example.homework9.dto.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MQController {

    private final MessageSender messageSender;

    @PostMapping("/messages")
    public void sendMessage(@RequestBody Message message) {
        messageSender.sendMessage(message);
    }

}
