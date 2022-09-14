package com.capg.config;

/*import org.springframework.amqp.core.*; 
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {
	
	public static final String CHECKINQ = "checkin_message_queue";
    public static final String CHECKINE = "checkin_message_exchange";
    public static final String CHECKIN_ROUTING_KEY = "checkin_message_routingKey";

    @Bean
    public Queue queue() {
        return  new Queue(CHECKINQ);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(CHECKINE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(CHECKIN_ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter() {
        return  new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return  template;
    }

}*/
