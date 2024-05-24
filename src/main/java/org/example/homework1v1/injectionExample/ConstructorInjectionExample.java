package org.example.homework1v1.injectionExample;

import org.example.homework1v1.service.MyService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConstructorInjectionExample {

    private final MyService myService;

    public ConstructorInjectionExample(@Qualifier("service1")MyService myService) {
        this.myService = myService;
    }
}
