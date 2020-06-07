package com.example.event.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.event.UserCreatedEvent;

@Component
public class UserCreatedEventConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserCreatedEventConsumer.class);

	@KafkaListener(topics = "${kafka.user-created.topic-name}", groupId = "${kafka.consumer.user-created.group-id}", containerFactory = "kafkaListenerContainerFactory")
	public void handle(UserCreatedEvent event) {
		LOGGER.info("UserCreatedEvent received - {} User created at {}", event.getUserId(), event.getCreationTime());
	}
}
