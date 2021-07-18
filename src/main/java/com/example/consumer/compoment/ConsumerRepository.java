package com.example.consumer.compoment;

import com.example.consumer.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("consumerRepository")
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
    Consumer findConsumerById(Long id);

    Consumer findConsumerByConsumerName(String consumerName);
}
