package cn.wntime.jpa.struct;

import cn.wntime.jpa.common.BaseMapper;
import cn.wntime.jpa.domain.UserInfo;
import cn.wntime.jpa.dto.UserInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserInfoMapper extends BaseMapper<UserInfoDto, UserInfo> {
}