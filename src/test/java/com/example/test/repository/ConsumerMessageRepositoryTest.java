package com.example.test.repository;

import com.example.consumer.compoment.ConsumerMessageRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jms.core.JmsTemplate;

/*
工序6 发送MQ

given Spy BusService Sender

when Repository 层方法xxx 调用Dummy 查询参数

then 验证jmsTemplate发送数据与Dummy相同
*/
@SpringBootTest
class ConsumerMessageRepositoryTest {

  @MockBean
  JmsTemplate jmsTemplate;
  @Autowired
  ConsumerMessageRepository consumerMessageRepository;

  @Test
  void should_call_jms_template_with_id_1_when_sendConsumerMessage_given_id_1() {

    //when
    consumerMessageRepository.sendConsumerMessage(1L);
    //then
    Mockito.verify(jmsTemplate).convertAndSend("consumer.service", 1L);
  }
}
