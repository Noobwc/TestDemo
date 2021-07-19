package com.example.consumer.api.consumer;

import com.example.consumer.entity.Producer;
import com.example.consumer.service.ProducerService;
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
    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
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
