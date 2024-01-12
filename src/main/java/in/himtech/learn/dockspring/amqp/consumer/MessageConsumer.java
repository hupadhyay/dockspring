package in.himtech.learn.dockspring.amqp.consumer;

import in.himtech.learn.dockspring.amqp.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class MessageConsumer {

    @RabbitListener(queues = {"${message.queue.name}"})
    public void consumeSimpleMessage(String str){
        log.info(String.format("Received Json Message -> %s",  str));
    }

    @RabbitListener(queues = {"${message.queue.json}"})
    public void consumerComplexMessage(Employee employee){
        log.info(String.format("Received Json Message -> %s",  employee.toString() ));
    }
}
