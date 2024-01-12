package in.himtech.learn.dockspring.amqp.controller;

import in.himtech.learn.dockspring.amqp.dto.Employee;
import in.himtech.learn.dockspring.amqp.producer.MessageProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/rabbit/")
public class MessageController {

    private MessageProducer messageProducer;

    @PostMapping("/send-msg")
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        this.messageProducer.sendMessage(message);
        return ResponseEntity.ok("Message has been send successfully!");
    }

    @PostMapping("/send-json-msg")
    public ResponseEntity<String> sendComplexMessage(@RequestBody Employee employee){
        this.messageProducer.sendComplexMessage(employee);
        return ResponseEntity.ok("Complex message has been send successfully!");
    }
}
