package com.example.test.integrationTest;

import com.example.consumer.compoment.ConsumerRepository;
import com.example.consumer.entity.Consumer;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/*
Integration Test

given Fack DB Mock Other Service

when Fack http 调用 url

then 验证返回值和数据库数据
*/
@SpringBootTest
@ExtendWith( {SpringExtension.class})
class ConsumerControllerTest {
    @Autowired
    private ConsumerRepository consumerRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
        consumerRepository.deleteAll();
    }

    @Test
    void should_return_all_consumer_when_call_consumers_url() {
        Consumer consumer = Consumer.builder().id(1L).consumerName("name").build();
        consumerRepository.save(consumer);

        RestAssuredMockMvc.given().get("/consumers")
                .then().statusCode(200)
                .expect(jsonPath("$..consumerName").value("name"));
    }

}
