package cn.wntime.jpa.controller;

import cn.wntime.jpa.domain.UserInfo;
import cn.wntime.jpa.repository.UserInfoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "用户操作类", tags = {"用户操作类"})
@RestController
@RequestMapping(path = "/user")
public class UserInfoController {

    final UserInfoRepository userInfoRepository;

    public UserInfoController(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @ApiOperation(value = "用户列表", httpMethod = "GET")
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<UserInfo> userInfoList() {
        return userInfoRepository.findAll();
    }

    @ApiOperation(value = "随机增加用户", httpMethod = "GET")
    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public UserInfo add() {

        UserInfo userInfo = new UserInfo();
        userInfo.setEmail(RandomStringUtils.random(3));
        userInfo.setUserName(RandomStringUtils.random(6));
        userInfoRepository.save(userInfo);
        return userInfo;
    }

    @ApiOperation(value = "一个抛异常方法", httpMethod = "GET")
    @RequestMapping(path = "/exception", method = RequestMethod.GET)
    public void exception() throws Exception {
        if (true)
            throw new Exception("测试异常");
        return;
    }

}
