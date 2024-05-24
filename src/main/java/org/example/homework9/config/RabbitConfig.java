package org.example.homework9.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String EXCHANGE_NAME = "homework";
    public static final String ROUTING_KEY_IN = "homework.in";
    public static final String QUEUE_NAME = "homework.rs";

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Declarables homeworkDeclarables() {
        var homeworkRs = new Queue("homework.rs", false);
        var homeworkExchange = new DirectExchange("homework");
        return new Declarables(
                homeworkRs,
                homeworkExchange,
                BindingBuilder.bind(homeworkRs).to(homeworkExchange).with("homework.rs")
        );
    }

}