package cn.wntime.jpa.domain;

import cn.wntime.jpa.domain.common.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * 组织信息
 */
@Data
@Entity
@Table(name = "org_info")
public class OrgInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组织id
     */
    @Id
    @SequenceGenerator(name = "org_info_org_id_seq", sequenceName = "org_info_org_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "org_info_org_id_seq")
    @Column(name = "org_id", nullable = false)
    private Long orgId;


}
