package com.capg.messageQueue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.*;

@Configuration
public class MQConfig {
	
    public static final String SEARCH_ROUTING_KEY = "Search message routing key";
    public static final String CHECKIN_ROUTING_KEY = "Checkin message routing key";
    public static final String SEARCHQ = "Ticketq";
    public static final String CHECKINQ = "Trainq";
    public static final String SEARCHE = "Tickete";
    public static final String CHECKINE = "Traine";
    
    @Bean
    public Queue ticketQueue(){
        return new Queue(SEARCHQ);
    }

    @Bean
    public Queue paymentQueue(){
        return new Queue(CHECKINQ);
    }
    
    @Bean
    public TopicExchange ticketExchange(){
        return new TopicExchange(SEARCHE);
    }
    @Bean
    public TopicExchange paymentExchange(){
        return new TopicExchange(CHECKINE);
    }
    
    

}
