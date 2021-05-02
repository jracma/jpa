package cn.wntime.jpa.domain;

import cn.wntime.jpa.common.BaseEntity;
import cn.wntime.jpa.common.Gender;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "user_info")
@ApiModel(value = "用户信息类", description = "用户基本信息:邮箱,手机号,登录名称,密码...")
public class UserInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "user_info_user_id_seq",
            sequenceName = "user_info_user_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_info_user_id_seq")
    @Column(name = "user_id", nullable = false)
    @ApiModelProperty(value = "用户id", example = "100")
    private Long userId;

    @Column(name = "email",unique = true,nullable = false)
    @ApiModelProperty(value = "电子邮箱", example = "aaa@aaa.com")
    private String email;

    @Column(name = "nick_name")
    @ApiModelProperty(value = "用户昵称", example = "王五")
    private String nickName;

    @Column(name = "login_name",unique = true,nullable = false)
    @ApiModelProperty(value = "用户登录名", example = "user")
    private String loginName;

    @Column(name = "password")
    @ApiModelProperty(value = "用户密码", example = "123456")
    private String password;

    @Column(name = "mobile_phone",unique = true,nullable = false)
    @ApiModelProperty(value = "手机号", example = "13912345678")
    private String mobilePhone;

    @OneToOne
    @ApiModelProperty(value = "用户岗位JOB", example = "1")
    private JobInfo jobInfo;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_gender")
    @ApiModelProperty(value = "用户性别", example = "MAIL")
    private Gender gender;

    @OneToMany(mappedBy = "user")
    private List<UserRoleRef> userRoleRefs;

}
