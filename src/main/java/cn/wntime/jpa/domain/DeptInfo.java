package cn.wntime.jpa.domain;

import cn.wntime.jpa.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * 区域信息
 */
@Data
@Entity
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
    private Integer deptSort;

    @NotBlank
    @ApiModelProperty(value = "部门名称")
    private String name;

    @NotNull
    @ApiModelProperty(value = "是否启用")
    private Boolean enabled;

    @ApiModelProperty(value = "上级部门")
    private Long pid;
}
