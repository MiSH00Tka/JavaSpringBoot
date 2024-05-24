package org.example.hopmework10.metrics.custom;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.hopmework10.dto.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class CustomAspect {

    MeterRegistry meterRegistry;

    @Around("@annotation(CustomMetric)")
    public Object countChocolateSales(ProceedingJoinPoint jp) {
        Object result;
        var method = ((MethodSignature) jp.getSignature()).getMethod();
        String metricName = method.getAnnotation(CustomMetric.class).name();
        try {
            result = jp.proceed();
            Order order = (Order) jp.getArgs()[0];
            meterRegistry.counter(metricName, "name", order.name()).increment(order.quantity());
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }
}
