package com.liyu.test;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.Cached;
import com.alicp.jetcache.anno.CreateCache;
import com.liyu.model.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author liyu
 * @date:2018/8/19
 * @describe:
 */
@Component
@Slf4j
public class SpringChace {

    @CreateCache
    Cache<String, UserDTO> userCache;

    @Cached(name = "saveUserDTO",expire = 100)
    public UserDTO saveUserDTO() {
        UserDTO userDTO=new UserDTO();
        userDTO.setUserName("wwj");
        userCache.put("123",userDTO);
        return userCache.get("123");
    }



}
