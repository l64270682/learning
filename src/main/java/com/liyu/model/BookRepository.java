package com.liyu.model;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liyu
 * @date:2018/9/27
 * @describe:
 */
@Repository
public interface BookRepository  extends ElasticsearchCrudRepository<Book,Long> {
}
