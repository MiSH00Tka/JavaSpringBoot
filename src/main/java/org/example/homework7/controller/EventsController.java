package org.example.homework7.controller;


import lombok.RequiredArgsConstructor;
import org.example.homework7.service.EventsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventsController {

    private final EventsService eventsService;

    @PostMapping("/simple")
    public void publishSimpleEvent() {
        eventsService.publishSimpleEvent();
    }

    @PostMapping("/async")
    public void publishAsyncEvent() {
        eventsService.publishAsyncEvent();
    }

    @PostMapping("/transactional1")
    public void publishTransactionalEvents1() {
        eventsService.publishTransactionalEvents1();
    }

    @PostMapping("/transactional2")
    public void publishTransactionalEvents2() {
        eventsService.publishTransactionalEvents2();
    }
}
