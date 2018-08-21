package com.liyu.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author liyu
 * @date:2018/8/19
 * @describe:
 */
@Component
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 8869489358504277272L;

    private String userName;

    private long userId;

    public String getUserName() {
        return userName;
    }

    public UserDTO() {
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public UserDTO(String userName, long userId) {
        this.userName = userName;
        this.userId = userId;
    }
}
