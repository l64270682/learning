package com.liyu.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * @author liyu
 * @date:2018/9/27
 * @describe:
 */
@Document(indexName = "book", type = "book_num", shards = 1)
@Data
public class Book {

    @Id
    private Long id;
    @Field
    private String accountName;
    @Field
    private String nickName;
}
