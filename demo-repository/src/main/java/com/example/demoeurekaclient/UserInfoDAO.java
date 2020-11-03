package com.example.demoeurekaclient;

import com.example.demoeurekaclient.module.UserInfoDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhanglirui
 * @date 2020/10/28 7:06 下午
 */
@Mapper
public interface UserInfoDAO {

    /**
     * 插入
     * @param userInfoDO
     * @return
     */
    int insert(UserInfoDO userInfoDO);
}
