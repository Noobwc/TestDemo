package com.example.consumer.api.consumer;

import com.example.consumer.entity.Consumer;
import com.example.consumer.service.ConsumerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/consumers")
public class ConsumerController {
    private final ConsumerService consumerService;

    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsumerDTO addConsumer(@RequestBody @Valid Consumer consumer) {
        return consumerService.addConsumer(consumer);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ConsumerDTO> getAllConsumer() {
        return consumerService.getAllConsumer();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConsumerDTO getConsumerById(@PathVariable Long id) {
        return consumerService.getConsumerById(id);
    }

}
