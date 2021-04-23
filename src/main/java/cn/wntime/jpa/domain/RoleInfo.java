package cn.wntime.jpa.domain;

import cn.wntime.jpa.common.BaseEntity;
import cn.wntime.jpa.common.DataLevel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
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

    @OneToMany(mappedBy = "dept")
    private List<DeptRoleRef> deptRoleRefs;

    @ApiModelProperty(value = "数据权限，全部 、 本级 、 自定义")
    private String dataLevel = DataLevel.LEVEL.getValue();

    @Column(name = "level")
    @ApiModelProperty(value = "级别，数值越小，级别越大")
    private Integer level = 3;

    @ApiModelProperty(value = "描述")
    private String description;

}
