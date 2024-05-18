package org.example.homework7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EventDemoApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(EventDemoApplication.class, args);
		var eventPublisher = context.getBean(EventPublisher.class);
		eventPublisher.createEvents();
	}

	@Component
	public static class EventPublisher implements ApplicationEventPublisherAware {

		private ApplicationEventPublisher eventPublisher;

		@Override
		public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
			this.eventPublisher = applicationEventPublisher;
		}

		public void createEvents() {
			eventPublisher.publishEvent(new NormalEvent("Normal Event"));

			eventPublisher.publishEvent(new AsyncEvent("Async Event"));

			eventPublisher.publishEvent(new TransactionalEvent("Event 1"));
			eventPublisher.publishEvent(new TransactionalEvent("Event 2"));
		}
	}

	@Component
	public static class EventListeners {

		@EventListener
		public void handleNormalEvent(NormalEvent event) {
			System.out.println("Normal Event handled: " + event.getMessage());
		}

		@Async
		@EventListener
		public void handleAsyncEvent(AsyncEvent event) {
			System.out.println("Async Event handled: " + event.getMessage());
		}

		@TransactionalEventListener
		public void handleTransactionalEvent(TransactionalEvent event) {
			System.out.println("Processing Transactional Event: " + event.getMessage());
		}
	}

	static class NormalEvent {
		private final String message;

		public NormalEvent(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
	}

	static class AsyncEvent {
		private final String message;

		public AsyncEvent(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
	}

	static class TransactionalEvent {
		private final String message;

		public TransactionalEvent(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
	}
}