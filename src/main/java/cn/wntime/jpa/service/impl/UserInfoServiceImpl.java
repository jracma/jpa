package cn.wntime.jpa.service.impl;

import cn.wntime.jpa.domain.UserInfo;
import cn.wntime.jpa.dto.UserInfoDto;
import cn.wntime.jpa.repository.UserInfoRepository;
import cn.wntime.jpa.service.UserInfoService;
import cn.wntime.jpa.struct.UserInfoMapper;
import lombok.RequiredArgsConstructor;
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
