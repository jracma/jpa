package cn.wntime.jpa.domain;

import cn.wntime.jpa.domain.common.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "role_info")
public class RoleInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "role_info_role_id_seq", sequenceName = "role_info_role_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_info_role_id_seq")
    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Column(name = "role_code")
    private String roleCode;

    @Column(name = "role_name")
    private String roleName;

}
