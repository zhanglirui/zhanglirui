package com.example.demoeurekaclient.impl;

import javax.annotation.Resource;

import com.example.demoeurekaclient.Interceptor.UserBeforInterceptor;
import com.example.demoeurekaclient.UserInfoDAO;
import com.example.demoeurekaclient.UserInfoService;
import com.example.demoeurekaclient.common.CommandManager;
import com.example.demoeurekaclient.entry.UserInfoQuery;
import com.example.demoeurekaclient.module.UserInfoDO;
import org.apache.ibatis.plugin.Intercepts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhanglirui
 * @date 2020/10/28 7:54 下午
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDAO userInfoDAO;

    @Autowired
    private CommandManager commandManager;

    @Override
    public int saveObject(UserInfoQuery query) {

        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setCreateUser(query.getCreateUser());
        userInfoDO.setGameId(query.getGameId());
        userInfoDO.setStatus(query.getStatus());

        int insert = userInfoDAO.insert(userInfoDO);
        return insert;
    }

}
