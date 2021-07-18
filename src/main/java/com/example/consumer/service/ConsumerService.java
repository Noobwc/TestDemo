package com.example.consumer.service;


import com.example.consumer.api.consumer.ConsumerDTO;
import com.example.consumer.compoment.ConsumerMessageRepository;
import com.example.consumer.compoment.ConsumerRepository;
import com.example.consumer.entity.Consumer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsumerService {
    private final ConsumerRepository consumerRepository;
    private final ConsumerMessageRepository consumerMessageRepository;

    public ConsumerService(ConsumerRepository consumerRepository, ConsumerMessageRepository consumerMessageRepository) {
        this.consumerRepository = consumerRepository;
        this.consumerMessageRepository = consumerMessageRepository;
    }

    public List<ConsumerDTO> getAllConsumer() {
        return consumerRepository.findAll().stream().map(Consumer::toDTO).collect(Collectors.toList());
    }

    public ConsumerDTO addConsumer(Consumer consumer) {
        consumerMessageRepository.sendConsumerMessage(consumer.getId());
        return consumerRepository.save(consumer).toDTO();
    }

    public ConsumerDTO getConsumerById(Long id) {
        return consumerRepository.findConsumerById(id).toDTO();
    }

    public ConsumerDTO updateRequest(String consumerName) {
        return consumerRepository.findConsumerByConsumerName(consumerName).toDTO();
    }
}
