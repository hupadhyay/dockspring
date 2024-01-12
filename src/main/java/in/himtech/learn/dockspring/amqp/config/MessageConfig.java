package in.himtech.learn.dockspring.amqp.config;

import lombok.Data;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class MessageConfig {
    @Value("${message.queue.name}")
    private String queueName;

    @Value("${message.queue.json}")
    private String queueJson;

    @Value("${message.exchange.name}")
    private String exchangeName;

    @Value("${message.binding.key}")
    private String routingKey;

    @Value("${message.binding.key.json}")
    private String routingKeyJson;

    @Bean
    public Queue msgQueue(){
        return new Queue(queueName);
    }

    @Bean
    public Queue msgJsonQueue(){
        return new Queue(queueJson);
    }
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(msgQueue())
                .to(exchange())
                .with(routingKey);
    }

    @Bean
    public Binding bindingJson(){
        return BindingBuilder
                .bind(msgJsonQueue())
                .to(exchange())
                .with(routingKeyJson);
    }

    @Bean
    public MessageConverter msgConverter(){
        return new Jackson2JsonMessageConverter();
    }

    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(msgConverter());
        return rabbitTemplate;
    }
}
