package com.example.consumer.entity;

import com.example.consumer.api.consumer.ConsumerDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Consumers")
public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String consumerName;

    public ConsumerDTO toDTO(){
        return ConsumerDTO.builder()
                .consumerName(consumerName)
                .build();
    }
}
