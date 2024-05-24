package org.example.homework4.components;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@ConditionalOnExpression("!'${env.var.exampleTest}'.equals('default')")
@Log4j2
public class EnvVarBean {
    @PostConstruct
    void init() {
        log.info("envVarBean created");
    }
}
