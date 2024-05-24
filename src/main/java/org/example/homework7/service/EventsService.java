package org.example.homework7.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.homework7.events.AsyncEvent;
import org.example.homework7.events.SimpleEvent;
import org.example.homework7.events.TransactionalEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Log4j2
public class EventsService {

    private final ApplicationEventPublisher eventPublisher;

    public void publishSimpleEvent() {
        SimpleEvent event = new SimpleEvent("SimpleEvent");
        log.info("Publishing SimpleEvent: {}", event);
        eventPublisher.publishEvent(event);
    }

    public void publishAsyncEvent() {
        AsyncEvent event = new AsyncEvent("AsyncEvent");
        log.info("Publishing AsyncEvent: {}", event);
        eventPublisher.publishEvent(event);
    }

    @Transactional
    public void publishTransactionalEvents1() {
        TransactionalEvent successEvent = new TransactionalEvent("SuccessTransactionalEvent");
        log.info("Publishing TransactionalEvent (success): {}", successEvent);
        eventPublisher.publishEvent(successEvent);
    }

    @Transactional
    public void publishTransactionalEvents2() {
        TransactionalEvent rollbackEvent = new TransactionalEvent("RollbackTransactionalEvent");
        log.info("Publishing TransactionalEvent (rollback): {}", rollbackEvent);
        eventPublisher.publishEvent(rollbackEvent);
        throw new RuntimeException("Rollback transaction");
    }
}
