package com.example.test.controller;

import com.example.consumer.api.consumer.ConsumerController;
import com.example.consumer.api.consumer.ConsumerDTO;
import com.example.consumer.service.ConsumerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
工序 1 正常http请求

given Spy Service xxx方法

when Fake Http Controller 方法xxx并传入json []

then 验证Service 被正常调用，且参数为[]，且返回值为200
*/
@WebMvcTest(ConsumerController.class)
@AutoConfigureJsonTesters
class ConsumerControllerTest {
    @MockBean
    private ConsumerService consumerService;

    @Autowired
    private MockMvc mockMvc;

    private List<ConsumerDTO> consumerDTOList;

    @BeforeEach
    public void setUp() {
        consumerDTOList = new ArrayList<>();
        consumerDTOList.add(new ConsumerDTO("name"));
    }

    @Test
    void should_return_list_consumer_when_get_all_consumer() throws Exception {
        when(consumerService.getAllConsumer()).thenReturn(consumerDTOList);

        this.mockMvc
                .perform(
                        get("/consumers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..consumerName").value("name"));
        verify(consumerService).getAllConsumer();
    }
}
