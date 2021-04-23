package cn.wntime.jpa.domain;

import cn.wntime.jpa.common.BaseEntity;
import cn.wntime.jpa.common.Gender;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_info")
@ApiModel(value = "用户信息类", description = "用户信息:邮箱,名称,登录名称,密码,手机号,性别")
public class UserInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "user_info_user_id_seq", sequenceName = "user_info_user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_user_id_seq")
    @Column(name = "user_id", nullable = false)
    @ApiModelProperty(value = "用户id", example = "100", reference = "这个显示在哪")
    private Long userId;

    @Column(name = "email")
    @ApiModelProperty(value = "电子邮箱", example = "aaa@aaa.com",required = true)
    private String email;

    @Column(name = "user_name")
    @ApiModelProperty(value = "用户昵称", example = "王五")
    private String nickName;

    @Column(name = "user_login_name")
    @ApiModelProperty(value = "用户登录名", example = "user",required = true)
    private String loginName;

    @Column(name = "password")
    @ApiModelProperty(value = "用户密码", example = "123456",required = true)
    private String password;

    @Column(name = "mobile_phone")
    @ApiModelProperty(value = "手机号", example = "13912345678",required = true)
    private String mobilePhone;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_gender")
    @ApiModelProperty(value = "用户性别",example = "MAIL")
    private Gender gender;

}
