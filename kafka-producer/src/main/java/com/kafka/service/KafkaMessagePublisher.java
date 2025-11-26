package com.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String,Object> template;

    public void sendMessage(String message){
        CompletableFuture<SendResult<String, Object>> future = template.send("kafka-appinventv", message);
        future.whenComplete((result,ex)->{
            if(ex==null){
                System.out.println("[ Sent Message is "+message +" Offset for message is "+
                        result.getRecordMetadata().offset()+"]");
            }else {
                System.out.println("Unable to Send Message = [ "+message+ " error is "+ex.getMessage());
            }
        });
    }

}
