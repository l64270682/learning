package com.liyu.model;

/**
 * @author liyu
 * @date:2018/12/13
 * @describe:
 */
public class BookImpl extends Book {

    private String accountName;




    public BookImpl(String accountName, String nickName, String accountName1) {
        super(accountName, nickName);
        this.accountName = accountName1;
    }
}
