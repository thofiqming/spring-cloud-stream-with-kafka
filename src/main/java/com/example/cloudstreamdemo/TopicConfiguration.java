package com.example.cloudstreamdemo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.binder.PollableMessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface TopicConfiguration {

    @Output("stream-demo-outbound")
    MessageChannel getOutboundChannelToPublish();

    /*@Input("stream-demo-inbound")
    PollableMessageSource getInboundChannelToConsume();*/

    @Input("stream-demo-inbound")
    SubscribableChannel getInboundChannelToConsume();
}
