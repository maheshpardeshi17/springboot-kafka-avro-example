# springboot-kafka-avro-example
Spring boot 2.3.0.RELEASE, Spring-Kafka 2.5.0.RELEASE, confluent 5.5.0 and Avro 1.9.2 Integration for Kafka Consumer and Producer


Prerequites to run the application


*   JDK
*   Maven
*   Kafka - Run on default settings
*   Confluent Schema Registry - Run on default settings 
 
Build >>  mvn clean install

Run >> mvn spring-boot:run

Publish an event >> http://localhost:8080/spring-boot-avro/publish
