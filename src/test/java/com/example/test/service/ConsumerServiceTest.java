package com.example.test.service;

import com.example.consumer.api.consumer.ConsumerDTO;
import com.example.consumer.compoment.ConsumerMessageRepository;
import com.example.consumer.compoment.ConsumerRepository;
import com.example.consumer.entity.Consumer;
import com.example.consumer.service.ConsumerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/*
工序3 happy path的业务逻辑

given Spy Repository

when Service 层方法xxx 调用，Dummy调用参数xx

then 验证Repository 被正常调用，且验证调用参数为xxx
*/
@SpringBootTest
class ConsumerServiceTest {
    private ConsumerService consumerService;
    @Mock
    ConsumerRepository consumerRepository;

    @Mock
    ConsumerMessageRepository consumerMessageRepository;

    @BeforeEach
    void setUp() {
        consumerService = new ConsumerService(consumerRepository, consumerMessageRepository);
    }

    @Test
    void should_return_consumer_list_when_get_all_consumer() {
        List<Consumer> consumerList = new ArrayList<>();
        consumerList.add(new Consumer(1L, "name"));

        when(consumerRepository.findAll()).thenReturn(consumerList);

        List<ConsumerDTO> allConsumer = consumerService.getAllConsumer();

        assertThat(allConsumer).isEqualTo(consumerList.stream().map(Consumer::toDTO).collect(Collectors.toList()));
        verify(consumerRepository).findAll();
    }
}
