package com.example.consumer.api.consumer;

import com.example.consumer.service.ConsumerService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class BusServiceHandler {
    private final ConsumerService consumerService;

    public BusServiceHandler(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @JmsListener(destination = "consumer.service.result")
    public void onGetUpdateConsumerRequest(ConsumerDTO consumerDTO){
        consumerService.updateRequest(consumerDTO.getConsumerName());
    }
}
