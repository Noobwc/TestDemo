package com.example.consumer.compoment;

import com.example.consumer.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("producerRepository")
public interface ProducerRepository extends JpaRepository<Producer, Long> {
}
