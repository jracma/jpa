package io.raute.jpa.service.impl;

import io.raute.jpa.domain.UserInfo;
import io.raute.jpa.dto.UserInfoDto;
import io.raute.jpa.repository.UserInfoRepository;
import io.raute.jpa.service.UserInfoService;
import io.raute.jpa.struct.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserInfoServiceImpl implements UserInfoService {


    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfoDto> findAll() {
        List<UserInfo> userInfos = userInfoRepository.findAll();
        List<UserInfoDto> userInfoDtos = userInfoMapper.toDto(userInfos);
        return userInfoDtos;
    }

}
