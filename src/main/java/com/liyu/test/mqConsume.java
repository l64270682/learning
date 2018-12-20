package com.liyu.test;

import com.liyu.config.MqConfig;
import com.liyu.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author liyu
 * @date:2018/12/11
 * @describe:
 */
@Component
@Slf4j
public class mqConsume {

    @RabbitListener(queues = MqConfig.REGISTER_QUEUE_NAME)
    public void listenerAutoAck1(Book book) {
        log.info("调用失败" );
        throw new RuntimeException();
    }
}
