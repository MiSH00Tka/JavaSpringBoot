package org.example.homework1v1.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class Service2 implements MyService {
    @PostConstruct
    public void init() {
        System.out.println("Service2.init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Service2.destroy");
    }
}
