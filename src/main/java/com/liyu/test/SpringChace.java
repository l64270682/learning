package com.liyu.test;

import com.liyu.model.Book;
import com.liyu.model.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Book saveBook() {
        Book book = new Book();
        book.setId(1L);
        book.setAccountName("红楼梦");
        book.setNickName("红楼梦第一回");
        bookRepository.save(book);
        Book bookOptional = bookRepository.findById(1L).get();
        return bookOptional;

    }


}
