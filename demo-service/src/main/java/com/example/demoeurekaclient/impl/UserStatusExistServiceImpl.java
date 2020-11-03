package com.example.demoeurekaclient.impl;

import com.example.demoeurekaclient.UserInfoDAO;
import com.example.demoeurekaclient.UserStatusService;
import com.example.demoeurekaclient.annotion.MyAnnotation;
import com.example.demoeurekaclient.entry.UserInfoQuery;
import com.example.demoeurekaclient.enums.StatusTypeEnum;
import com.example.demoeurekaclient.module.UserInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhanglirui
 * @date 2020/11/3 10:49 上午
 */
@Component
@MyAnnotation(type = StatusTypeEnum.EXIST)
public class UserStatusExistServiceImpl implements UserStatusService {

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Override
    public int saveUserInfo(UserInfoQuery query) {
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setCreateUser(query.getCreateUser());
        userInfoDO.setGameId(query.getGameId());
        userInfoDO.setStatus(query.getStatus());

        int insert = userInfoDAO.insert(userInfoDO);
        return insert;
    }

    @Override
    public int updateUserInfo(UserInfoQuery query) {
        return 0;
    }
}
