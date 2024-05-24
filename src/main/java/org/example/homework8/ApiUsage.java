package org.example.homework8;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApiUsage {

    @Value("${api.max_calls}")
    private int maxCalls;
    private int apiCallsCount = 0;

    @Before("@annotation(ApiMethod)")
    public void countApiCall() {
        apiCallsCount++;
        if (apiCallsCount > maxCalls) {
            throw new RuntimeException("Превышено максимальное количество обращений к API методам");
        }
    }
}