package com.example.test.repository;

import com.example.feign.controller.BookController;
import com.example.feign.feign.IBookClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/*
* Before mocking Feign clients Test
* */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class MockFeignClientTest {


    @MockBean
    private IBookClient iBookClient;

    @Autowired
    public BookController bookController;

    @Test
    void test() {
        Mockito.when(iBookClient.bookTest()).thenReturn("DUMMY");
        ResponseEntity<String> stringResponseEntity = bookController.bookTitle();

        assertThat(stringResponseEntity.getBody(), is("DUMMY"));
        assertThat(stringResponseEntity.getStatusCodeValue(), is(200));
    }

}

