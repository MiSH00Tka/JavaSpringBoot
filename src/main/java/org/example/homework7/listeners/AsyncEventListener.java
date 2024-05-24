package org.example.homework7.listeners;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.example.homework7.events.AsyncEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class AsyncEventListener {
    @Async
    @EventListener
    @SneakyThrows
    public void handleAsyncEvent(AsyncEvent event) {
        Thread.sleep(5000);
        log.info("Handling AsyncEvent: {}", event);
    }
}
