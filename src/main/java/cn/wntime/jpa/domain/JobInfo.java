package cn.wntime.jpa.domain;

import cn.wntime.jpa.common.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 岗位信息
 */
@Data
@Entity
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
    private String name;

    @NotNull
    @ApiModelProperty(value = "岗位排序")
    private Long jobSort;

    @NotNull
    @ApiModelProperty(value = "是否启用")
    private Boolean enabled;
}
