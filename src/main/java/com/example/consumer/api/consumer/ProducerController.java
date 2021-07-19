package com.example.producer.api.producer;

import com.example.consumer.entity.Producer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/producers")
public class ProducerController {
    private final com.example.producer.service.ProducerService producerService;

    public ProducerController(com.example.producer.service.ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producer addProducer(@RequestBody @Valid Producer producer) {
        return producerService.addProducer(producer);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Producer> getAllProducer() {
        return producerService.getAllProducer();
    }
}
