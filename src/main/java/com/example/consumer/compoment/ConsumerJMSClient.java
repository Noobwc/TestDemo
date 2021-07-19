package com.example.consumer.compoment;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ConsumerJMSClient implements ConsumerMessageRepository {

  private final JmsTemplate jmsTemplate;

  public ConsumerJMSClient(JmsTemplate jmsTemplate) {
    this.jmsTemplate = jmsTemplate;
  }

  @Override
  public void sendConsumerMessage(Long id) {
    jmsTemplate.convertAndSend("consumer.service", id);
  }

  @Override
  public void sendExpenseCalenderMessage(String message) {
    jmsTemplate.convertAndSend("consumer.service.expense", message);
  }
}
