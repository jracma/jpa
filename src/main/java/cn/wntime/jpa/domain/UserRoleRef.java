package cn.wntime.jpa.domain;

import cn.wntime.jpa.common.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Accessors(chain = true)
public class UserRoleRef extends BaseEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "user_role_ref_id_seq", sequenceName = "user_role_ref_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_ref_id_seq")
    private Long refId;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo user;

    @ManyToOne(fetch = FetchType.LAZY)
    private RoleInfo role;

}
