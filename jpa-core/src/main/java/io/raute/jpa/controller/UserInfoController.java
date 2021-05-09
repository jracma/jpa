package io.raute.jpa.controller;

import io.raute.jpa.domain.UserInfo;
import io.raute.jpa.repository.UserInfoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "/user", tags = {"用户操作类"},description = "")
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

    @ApiOperation(value = "增加用户", httpMethod = "POST" )
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public UserInfo add(@RequestBody UserInfo userInfo) {
        userInfoRepository.save(userInfo);
        return userInfo;
    }

}
