package com.example.event.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.example.event.UserCreatedEvent;

@Component
public class UserCreatedEventProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserCreatedEventProducer.class);
	
	private KafkaTemplate<String, UserCreatedEvent> kafkaTemplate;

	public UserCreatedEventProducer(KafkaTemplate<String, UserCreatedEvent> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

	public void send(UserCreatedEvent event) {
		ListenableFuture<SendResult<String, UserCreatedEvent>> result = kafkaTemplate.send("user-created", event);
		result.addCallback(new ListenableFutureCallback<SendResult<String, UserCreatedEvent>>() {

			@Override
			public void onSuccess(SendResult<String, UserCreatedEvent> result) {
				LOGGER.info("UserCreatedEvent has been published successfully");
			}

			@Override
			public void onFailure(Throwable ex) {
				LOGGER.info("Error occoured while publishing UserCreatedEvent : " + ex);
			}

		});
	}

}
