package cn.wntime.jpa.domain;

import cn.wntime.jpa.common.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 区域信息
 */
@Data
@Entity
@Accessors(chain = true)
@Table(name = "dept_info")
public class DeptInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 区域ID
     */
    @Id
    @SequenceGenerator(name = "dept_info_dept_id_seq", sequenceName = "dept_info_dept_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_info_dept_id_seq")
    @Column(name = "dept_id", nullable = false)
    private Long deptId;

    @ApiModelProperty(value = "排序")
    @Column(nullable = false)
    private Integer deptSort;

    @NotBlank
    @ApiModelProperty(value = "部门名称")
    @Column(unique = true,nullable = false,length = 128)
    private String name;

    @NotBlank
    @ApiModelProperty(value = "部门编码")
    @Column(unique = true,nullable = false,length = 128)
    private String code;

    @NotNull
    @ApiModelProperty(value = "是否启用")
    private Boolean enabled;

    @ApiModelProperty(value = "上级部门")
    private Long pid;

    @OneToMany(mappedBy = "dept",fetch = FetchType.LAZY)
    private List<DeptJobRef> deptJobRefs;

}
