package org.example.homework1v1.injectionExample;

import org.example.homework1v1.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FieldInjectionExample {

    @Autowired
    @Qualifier("service2")
    private MyService service;
}
