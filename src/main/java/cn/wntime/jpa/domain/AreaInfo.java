package cn.wntime.jpa.domain;

import cn.wntime.jpa.domain.common.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * 区域信息
 */
@Data
@Entity
@Table(name = "area_info")
@Deprecated
public class AreaInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 区域ID
     */
    @Id
    @SequenceGenerator(name = "area_info_area_id_seq", sequenceName = "area_info_area_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "area_info_area_id_seq")
    @Column(name = "area_id", nullable = false)
    private Long areaId;


}
