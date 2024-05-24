package org.example.homework2.controller;

import org.example.homework2.dto.Order;
import org.example.homework2.dto.OrderInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {
    private Long id = 1L;

    @PostMapping("/processJson")
    public Order processJson(@RequestBody Order orderRequest) {
        return new Order(orderRequest.price(), new OrderInfo(id++, orderRequest.info().date()));
    }
}
