package com.example.demoeurekaclient;

import com.example.demoeurekaclient.entry.UserInfoQuery;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhanglirui
 * @date 2020/11/3 10:41 上午
 */
public interface UserStatusService {

    /**
     * 保存用户信息
     * @param query
     * @return
     */
    int saveUserInfo(@Param("query") UserInfoQuery query);

    /**
     * 修改用户信息
     * @param query
     * @return
     */
    int updateUserInfo(@Param("query") UserInfoQuery query);

}
