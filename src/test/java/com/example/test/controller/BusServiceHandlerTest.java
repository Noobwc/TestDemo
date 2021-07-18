package com.example.test.controller;

import com.example.TestDemoApplication;
import com.example.consumer.api.consumer.BusServiceHandler;
import com.example.consumer.api.consumer.ConsumerDTO;
import com.example.consumer.service.ConsumerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/*
工序2 接收MQ

given Spy Service xxx方法

when BusserviceConsumer 方法xxx并传入json []

then 验证Service 被正常调用，且参数为[]
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestDemoApplication.class)
class BusServiceHandlerTest {
    @MockBean
    private ConsumerService consumerService;
    @Autowired
    BusServiceHandler busServiceHandler;

    @Test
    void should_call_consumer_service_update_request_with_consumerName_name_when_get_update_request() {
        //when
        busServiceHandler
                .onGetUpdateConsumerRequest(ConsumerDTO.builder().consumerName("name").build());
        //then
        Mockito.verify(consumerService).updateRequest("name");
    }
}
