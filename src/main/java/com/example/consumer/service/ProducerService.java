package com.example.producer.service;

import com.example.consumer.compoment.ProducerRepository;
import com.example.consumer.entity.Producer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService {
    private final ProducerRepository producerRepository;

    public ProducerService(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    public List<Producer> getAllProducer() {
        return producerRepository.findAll();
    }

    public Producer addProducer(Producer producer) {
        return producerRepository.save(producer);
    }
}
