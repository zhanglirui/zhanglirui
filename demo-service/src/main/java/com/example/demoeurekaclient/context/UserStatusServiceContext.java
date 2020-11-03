package com.example.demoeurekaclient.context;

import java.util.HashMap;
import java.util.Map;

import com.example.demoeurekaclient.UserStatusService;
import org.springframework.stereotype.Component;

/**
 * @author zhanglirui
 * @date 2020/11/3 10:57 上午
 */
@Component
public class UserStatusServiceContext {

    private final Map<Integer, UserStatusService> beansMap = new HashMap<>();

    public UserStatusService getUserStatusService(Integer type){
        return beansMap.get(type);
    }

    public void putUserStatusService(Integer code,UserStatusService userStatusService){
       beansMap.put(code,userStatusService);
    }
}
