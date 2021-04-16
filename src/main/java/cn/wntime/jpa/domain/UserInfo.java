package cn.wntime.jpa.domain;

import cn.wntime.jpa.domain.common.BaseEntity;
import cn.wntime.jpa.domain.common.Gender;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "user_info")
public class UserInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "user_info_user_id_seq",sequenceName = "user_info_user_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_info_user_id_seq")
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "email")
    private String email;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_gender")
    private Gender gender;

}
