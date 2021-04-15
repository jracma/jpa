package cn.wntime.jpa.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 系统资源信息，菜单，按钮
 */
@Data
@Entity
@Table(name = "res_info")
public class ResInfo implements Serializable {

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

}
