package org.example.hopmework10.controller;

import lombok.RequiredArgsConstructor;
import org.example.hopmework10.dto.Order;
import org.example.hopmework10.metrics.counter.CounterMetric;
import org.example.hopmework10.metrics.custom.CustomMetric;
import org.example.hopmework10.metrics.timer.TimerMetric;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiController {

    @GetMapping("method")
    @CounterMetric(name = "simpleMethod_counter")
    @TimerMetric(name = "simpleMethod_timer")
    public void simpleMethod() {
    }

    @PostMapping("buy/chocolate")
    @CustomMetric(name = "chocolateCountersByName")
    public Order buyChocolate(@RequestBody Order order) {
        return order;
    }

}
