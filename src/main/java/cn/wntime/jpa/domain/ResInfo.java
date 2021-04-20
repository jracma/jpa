package cn.wntime.jpa.domain;

import cn.wntime.jpa.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * 系统资源信息，菜单，按钮
 */
@Data
@Entity
@Table(name = "res_info")
public class ResInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @SequenceGenerator(name = "res_info_res_id_seq",sequenceName = "res_info_res_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "res_info_res_id_seq")
    @Column(name = "res_id", nullable = false)
    private Long resId;

    @Column(name = "res_code")
    private String resCode;

    /**
     * 上级
     */
    @Column(name = "res_parent")
    private Long resParent;

    /**
     * 排序
     */
    @Column(name = "res_order")
    private Long resOrder;

    /**
     * 名称
     */
    @Column(name = "res_name")
    private String resName;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "排序")
    private Integer resSort = 999;

    @ApiModelProperty(value = "组件路径")
    private String component;

    @ApiModelProperty(value = "路由地址")
    private String path;


    @ApiModelProperty(value = "资源类型，目录、菜单、按钮")
    private Integer type;

    @ApiModelProperty(value = "权限标识")
    private String permission;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "是否隐藏")
    private Boolean hidden;

    @ApiModelProperty(value = "外链菜单")
    private Boolean iFrame;

    @JsonIgnore
    @ManyToMany(mappedBy = "ress")
    @ApiModelProperty(value = "菜单角色")
    private Set<RoleInfo> roles;

}
