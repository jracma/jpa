package cn.wntime.jpa.domain;

import cn.wntime.jpa.common.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 岗位信息
 */
@Data
@Entity
@Accessors(chain = true)
@Table(name = "job_info")
public class JobInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组织id
     */
    @Id
    @SequenceGenerator(name = "job_info_job_id_seq", sequenceName = "job_info_job_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_info_job_id_seq")
    @Column(name = "job_id", nullable = false)
    private Long jobId;

    @NotBlank
    @ApiModelProperty(value = "岗位名称")
    @Column(unique = true,nullable = false,length = 127)
    private String name;

    @NotNull
    @ApiModelProperty(value = "岗位排序")
    private Integer jobSort;

    @NotNull
    @ApiModelProperty(value = "岗位数据权限,大的能看小的的数据.")
    private Integer jobData;

    @NotNull
    @ApiModelProperty(value = "是否启用")
    private Boolean enabled;

    @OneToMany(mappedBy = "job")
    private List<JobRoleRef> jobRoleRefs;

    @OneToMany(mappedBy = "job",fetch = FetchType.LAZY)
    private List<DeptJobRef> deptJobRefs;
}
