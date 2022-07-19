package com.example.cloudstreamdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableKafka
@EnableScheduling
@EnableBinding(TopicConfiguration.class)
public class CloudstreamdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudstreamdemoApplication.class, args);
	}

}
