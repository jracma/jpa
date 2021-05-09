package io.raute.jpa.domain;

import io.raute.jpa.common.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Accessors(chain = true)
public class RoleResRef  extends BaseEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "role_res_ref_id_seq", sequenceName = "role_res_ref_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_res_ref_id_seq")
    @Column(name = "ref_id", nullable = false)
    private Long refId;


    @ManyToOne(fetch = FetchType.LAZY)
    private RoleInfo role;


    @ManyToOne(fetch = FetchType.LAZY)
    private ResInfo res;

}
