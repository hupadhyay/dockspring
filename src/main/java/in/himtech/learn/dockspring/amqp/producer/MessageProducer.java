package in.himtech.learn.dockspring.amqp.producer;

import in.himtech.learn.dockspring.amqp.config.MessageConfig;
import in.himtech.learn.dockspring.amqp.dto.Employee;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class MessageProducer {
    private MessageConfig messageConfig;
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message){
        log.info(String.format("Message send -> %s", message));
        this.rabbitTemplate.convertAndSend(messageConfig.getExchangeName(), messageConfig.getRoutingKey(), message);
    }

    public void sendComplexMessage(Employee employee){
        log.info(String.format("Message send -> %s", employee));
        this.rabbitTemplate.convertAndSend(messageConfig.getExchangeName(), messageConfig.getRoutingKeyJson(), employee);
    }
}
