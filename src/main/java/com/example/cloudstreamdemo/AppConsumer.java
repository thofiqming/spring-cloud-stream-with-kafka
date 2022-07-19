package com.example.cloudstreamdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class AppConsumer {

    @Autowired
    private TopicConfiguration topicConfiguration;

    /*@Scheduled(fixedDelay = 2000)
    public void consume(){
        System.out.println("Consumer consuming message for every 2 seconds ....");
        this.topicConfiguration.getInboundChannelToConsume().poll(messageHandler -> {
            String payload = (String) messageHandler.getPayload();
            System.out.println(payload);
        }, new ParameterizedTypeReference<String>() {
        });
    }*/

    @StreamListener("stream-demo-inbound")
    public void consume(AppData message){
        System.out.println(message);
    }
}
