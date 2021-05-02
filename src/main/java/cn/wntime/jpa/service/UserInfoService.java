package cn.wntime.jpa.service;

import cn.wntime.jpa.dto.UserInfoDto;

import java.util.List;

public interface UserInfoService {
    List<UserInfoDto> findAll();
}
