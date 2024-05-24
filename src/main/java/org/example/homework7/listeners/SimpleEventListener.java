package org.example.homework7.listeners;

import lombok.extern.log4j.Log4j2;
import org.example.homework7.events.SimpleEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class SimpleEventListener {
    @EventListener
    public void handleSimpleEvent(SimpleEvent event) {
        log.info("Handling SimpleEvent: {}", event);
    }
}
