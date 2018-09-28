package com.liyu.test;

import com.liyu.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyu
 * @date:2018/8/19
 * @describe:
 */

@RestController
public class Controller {

    @Autowired
    SpringChace springChace;

    @GetMapping("/v1/task/test")
    @ResponseBody
    public ResponseEntity<?> taskStatus() {
        Book book = springChace.saveBook();
        return ResponseEntity.ok(book);
    }

}
