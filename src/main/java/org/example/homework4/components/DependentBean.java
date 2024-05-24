package org.example.homework4.components;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@ConditionalOnBean(TestBean.class)
@Log4j2
public class DependentBean {
    @PostConstruct
    void init() {
        log.info("dependentBean created");
    }
}
