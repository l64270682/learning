package com.liyu.test;

import com.liyu.config.MqConfig;
import com.liyu.model.Book;
import com.liyu.model.BookImpl;
import com.liyu.model.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.liyu.config.MqConfig.ROUTING_KEY;

/**
 * @author liyu
 * @date:2018/8/19
 * @describe:
 */
@Slf4j
@Service
public class SpringChace {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public Book saveBook() {
        Book book = new Book();
        book.setId(1L);
        book.setAccountName("红楼梦");
        book.setNickName("红楼梦第一回");
        bookRepository.save(book);
        Book bookOptional = bookRepository.findById(1L).get();
        return bookOptional;
    }

    public void sendMq() {
        Book book = new Book();
        BookImpl book1 = new BookImpl("11", "22", "33");
        book.setNickName("liyu");
        rabbitTemplate.convertAndSend(MqConfig.REGISTER_EXCHANGE_NAME, ROUTING_KEY, book, message -> {
            message.getMessageProperties().setExpiration(5 * 10000 + "");
            return message;
        });
    }


}
