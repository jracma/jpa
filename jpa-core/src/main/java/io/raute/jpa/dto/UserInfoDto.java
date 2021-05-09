package io.raute.jpa.dto;

import io.raute.jpa.common.Gender;
import io.raute.jpa.domain.JobInfo;
import io.raute.jpa.domain.UserRoleRef;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class UserInfoDto {
    private Long userId;
    private String email;
    private String nickName;
    private String loginName;
    private String password;
    private String mobilePhone;
    private JobInfo jobInfo;
    private Gender gender;
    private List<UserRoleRef> userRoleRefs;
}
