package com.liyu.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyu
 * @date:2018/12/11
 * @describe:
 */
@Configuration
public class MqConfig {

    public static final String DEFAULT_BOOK_QUEUE = "dev.book.register.default.queue";
    public static final String MANUAL_BOOK_QUEUE = "dev.book.register.manual.queue";


    /**
     * 延迟队列 TTL 名称
     */
    private static final String REGISTER_DELAY_QUEUE = "dev.book.register.delay.queue";
    /**
     * DLX，dead letter发送到的 exchange
     * TODO 此处的 exchange 很重要,具体消息就是发送到该交换机的
     */
    public static final String REGISTER_DELAY_EXCHANGE = "dev.book.register.delay.exchange";


    /**
     * routing key 名称
     * TODO 此处的 routingKey 很重要要,具体消息发送在该 routingKey 的
     */
    public static final String DELAY_ROUTING_KEY = "";


    public static final String REGISTER_QUEUE_NAME = "dev.book.register.queue";
    public static final String REGISTER_EXCHANGE_NAME = "dev.book.register.exchange";
    public static final String ROUTING_KEY = "all";
    /**
     *
     *
     * @return
     */
    @Bean
    public Queue delayProcessQueue() {
        Map<String, Object> params = new HashMap<>();
        // x-dead-letter-exchange 声明了队列里的死信转发到的DLX名称，
        params.put("x-dead-letter-exchange", REGISTER_EXCHANGE_NAME);
        // x-dead-letter-routing-key 声明了这些死信在转发时携带的 routing-key 名称。
        params.put("x-dead-letter-routing-key", ROUTING_KEY);
        return new Queue(MqConfig.REGISTER_DELAY_QUEUE, true, false, false, params);
    }

    @Bean
    DirectExchange delayExchange() {
        return new DirectExchange("delayExchange");
    }

    @Bean
    Binding dlxBinding() {
        return BindingBuilder.bind(delayProcessQueue()).to(delayExchange()).with(DELAY_ROUTING_KEY);
    }




    @Bean
    public Queue registerBookQueue() {
        return new Queue(MqConfig.REGISTER_QUEUE_NAME,true);
    }

    @Bean
    TopicExchange bookExchange() {
        return new TopicExchange(REGISTER_EXCHANGE_NAME);
    }

    @Bean
    Binding registerBookBinding() {
        return BindingBuilder.bind(registerBookQueue()).to(bookExchange()).with(ROUTING_KEY);
    }


}
