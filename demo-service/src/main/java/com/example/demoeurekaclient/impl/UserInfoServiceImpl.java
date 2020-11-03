package com.example.demoeurekaclient.impl;

import com.example.demoeurekaclient.UserInfoDAO;
import com.example.demoeurekaclient.UserInfoService;
import com.example.demoeurekaclient.entry.UserInfoQuery;
import com.example.demoeurekaclient.module.UserInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhanglirui
 * @date 2020/10/28 7:54 下午
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDAO userInfoDAO;

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