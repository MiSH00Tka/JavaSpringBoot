package org.example.homework7.listeners;

import lombok.extern.log4j.Log4j2;
import org.example.homework7.events.TransactionalEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import static org.springframework.transaction.event.TransactionPhase.AFTER_ROLLBACK;

@Service
@Log4j2
public class TransactionalEventsListener {
    @Async
    @TransactionalEventListener(phase = AFTER_ROLLBACK)
    public void handleRollbackEvent(TransactionalEvent event) {
        log.info("Handling TransactionalEvent (AFTER_ROLLBACK): {}", event);
    }
}
