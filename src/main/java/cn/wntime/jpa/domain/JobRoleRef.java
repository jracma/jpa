package cn.wntime.jpa.domain;

import cn.wntime.jpa.common.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Accessors(chain = true)
public class JobRoleRef  extends BaseEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "job_role_ref_id_seq", sequenceName = "job_role_ref_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_role_ref_id_seq")
    @Column(name = "ref_id", nullable = false)
    private Long refId;

    @ManyToOne(fetch = FetchType.LAZY)
    private RoleInfo role;

    @ManyToOne(fetch = FetchType.LAZY)
    private JobInfo job;

}
