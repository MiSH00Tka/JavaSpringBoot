package org.example.hopmework10.actuator;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
@Endpoint(id = "date")
@Log4j2
public class DateActuator {

    @ReadOperation
    public void date() {
        log.info("Actuator called - " + OffsetDateTime.now());
    }
}
