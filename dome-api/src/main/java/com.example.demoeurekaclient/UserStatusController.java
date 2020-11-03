package com.example.demoeurekaclient;

import java.util.Date;

import javax.annotation.Resources;

import com.example.demoeurekaclient.context.UserStatusServiceContext;
import com.example.demoeurekaclient.entry.UserInfoQuery;
import com.example.demoeurekaclient.result.BaseResult;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanglirui
 * @date 2020/11/3 11:09 上午
 */
@RestController
@RequestMapping("UserStatus")
public class UserStatusController {

    @Autowired
    private UserStatusServiceContext context;

    @RequestMapping(method = RequestMethod.GET,name = "create")
    public BaseResult userStatusCreate(@RequestParam("status") Integer status,@RequestParam("user") String user){
        UserStatusService userStatusService = context.getUserStatusService(status);

        UserInfoQuery query = new UserInfoQuery();
        query.setStatus(status);
        query.setGmtCreate(new Date());
        query.setCreateUser(user);

        int userInfo = userStatusService.saveUserInfo(query);

        BaseResult baseResult = new BaseResult();
        baseResult.setData(userInfo);
        baseResult.setSuccess(true);
        return baseResult;
    }
}
