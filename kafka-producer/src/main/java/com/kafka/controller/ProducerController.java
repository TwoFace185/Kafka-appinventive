package com.kafka.controller;

import com.kafka.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")
public class ProducerController {

    @Autowired
    private KafkaMessagePublisher publisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publisheMessage(@PathVariable String message){
        try{
            publisher.sendMessage(message);
            return ResponseEntity.ok("Message published Successfully...");
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/bulkmessage")
    public ResponseEntity<?> publishBulkMessage(){
        try{
            for(int i=0; i<1000; i++){
                publisher.sendMessage("Bulk message number "+i);
            }
            return ResponseEntity.ok("Bulk Message Produced Succesfully...");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
