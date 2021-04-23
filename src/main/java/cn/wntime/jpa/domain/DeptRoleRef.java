package cn.wntime.jpa.domain;

import cn.wntime.jpa.common.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DeptRoleRef  extends BaseEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "dept_role_ref_id_seq", sequenceName = "dept_role_ref_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_role_ref_id_seq")
    @Column(name = "dept_role_ref_id", nullable = false)
    private Long deptRoleRefId;

    @ManyToOne(fetch = FetchType.LAZY)
    private RoleInfo role;

    @ManyToOne(fetch = FetchType.LAZY)
    private DeptInfo dept;
}
