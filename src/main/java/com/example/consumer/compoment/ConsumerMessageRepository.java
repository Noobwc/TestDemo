package com.example.consumer.compoment;

import org.springframework.stereotype.Service;

@Service
public interface ConsumerMessageRepository {

  void sendConsumerMessage(Long id);
}
