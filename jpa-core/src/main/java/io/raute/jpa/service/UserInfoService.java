package io.raute.jpa.service;

import io.raute.jpa.dto.UserInfoDto;

import java.util.List;

public interface UserInfoService {
    List<UserInfoDto> findAll();
}
