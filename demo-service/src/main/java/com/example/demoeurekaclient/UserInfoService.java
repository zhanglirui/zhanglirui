package com.example.demoeurekaclient;

import com.example.demoeurekaclient.entry.UserInfoQuery;

/**
 * @author zhanglirui
 * @date 2020/10/28 7:54 下午
 */
public interface UserInfoService {

    /**
     * 插入对象
     * @param query
     * @return
     */
    int saveObject(UserInfoQuery query);
}
