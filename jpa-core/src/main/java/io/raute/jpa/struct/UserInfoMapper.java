package io.raute.jpa.struct;

import io.raute.jpa.common.BaseMapper;
import io.raute.jpa.domain.UserInfo;
import io.raute.jpa.dto.UserInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserInfoMapper extends BaseMapper<UserInfoDto, UserInfo> {
}