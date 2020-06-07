package com.example.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.event.UserCreatedEvent;
import com.example.event.producer.UserCreatedEventProducer;

@RestController
@RequestMapping("/spring-boot-avro")
public class SpringBootAvroController {
	
	@Autowired
	private UserCreatedEventProducer producer;
	
	@GetMapping("/publish")
	public ResponseEntity<Object> publish() {
		producer.send(new UserCreatedEvent(UUID.randomUUID().toString(), System.currentTimeMillis()));
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
