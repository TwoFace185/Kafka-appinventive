package com.kafkab.listener;


import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class kafkaMessageListener {

    @KafkaListener(topics = "sp-1" , groupId = "sp-1")
    public void consumer1(String message){
        System.out.println("Consumer 1  consumed message "+message);
    }

    @KafkaListener(topics = "sp-1" , groupId = "sp-1")
    public void consumer2(String message){
        System.out.println("Consumer 2  consumed message "+message);
    }

    @KafkaListener(topics = "sp-1" , groupId = "sp-1")
    public void consumer3(String message){
        System.out.println("Consumer 3  consumed message "+message);
    }

    @KafkaListener(topics = "sp-1" , groupId = "sp-1")
    public void consumer4(String message){
        System.out.println("Consumer 4  consumed message "+message);
    }

}
