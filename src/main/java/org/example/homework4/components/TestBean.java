package org.example.homework4.components;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("test")
@Log4j2
public class TestBean {
    @PostConstruct
    void init() {
        log.info("testBean created");
    }
}
