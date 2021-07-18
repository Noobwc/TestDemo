package com.example.test.repository;

import com.example.TestDemoApplication;
import com.example.consumer.compoment.ConsumerRepository;
import com.example.consumer.entity.Consumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

/*
工序4 数据库查询方法

given Fake DB，编写 Migration 增加表xxx，增加Entity xxx Stub 待查询数据

when Repository 层方法xxx 调用Dummy 查询参数

then 验证返回值与Stub数据相同

工序5 数据库保存

given Fake DB，编写 Migration 增加表xxx，增加Entity xxx Stub 待查询数据

when Repository 层方法xxx 调用Dummy 查询待保存数据

then 验证数据被正常保存
*/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestDemoApplication.class)
class ConsumerRepositoryTest {
    @Autowired
    private ConsumerRepository consumerRepository;

    @BeforeEach
    void setUp() {
        consumerRepository.deleteAll();
    }
    //工序4
    @Test
    void should_return_consumer_when_add_consumer(){
        Consumer consumer = Consumer.builder()
                .id(1L)
                .consumerName("name")
                .build();
        Consumer save = consumerRepository.save(consumer);
        assertThat(save).isEqualTo(consumer);
    }

    //工序5
    @Test
    void should_return_same_consumer_when_given_consumer_and_find_it() {
        Consumer consumer = Consumer.builder()
                .id(2L)
                .consumerName("name")
                .build();
        consumerRepository.save(consumer);
        Consumer consumerById = consumerRepository.findConsumerById(2L);

        assertThat(consumerById).isNotNull();
        assertThat(consumerById).isEqualTo(consumer);
    }
}
