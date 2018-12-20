package com.liyu.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * @author liyu
 * @date:2018/9/27
 * @describe:
 */
@Document(indexName = "book", type = "book_num", shards = 1)
@Data
public class Book implements Serializable {

    private static final long serialVersionUID = -8882864393680801191L;
    @Id
    private Long id;
    @Field
    private String accountName;
    @Field
    private String nickName;

    public Book() {
    }

    public Book(String accountName, String nickName) {
        this.accountName = accountName;
        this.nickName = nickName;
    }
}
