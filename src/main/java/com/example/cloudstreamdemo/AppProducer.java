package com.example.cloudstreamdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.MimeTypeUtils;

import java.util.UUID;

@Configuration
public class AppProducer {

    @Autowired
    private TopicConfiguration topicConfiguration;

    @Scheduled(fixedDelay = 2000)
    public void publishInfo() {
        System.out.println("Producer is producing the data for every 2 seconds ....");
        AppData appData = new AppData(UUID.randomUUID().toString());
        Message<AppData> message = MessageBuilder
                .withPayload(appData)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build();
        this.topicConfiguration.getOutboundChannelToPublish().send(message);
    }
}
