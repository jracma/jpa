package cn.wntime.jpa.domain.common;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity {

    private Long createUserId;
    private Date createDate;
    private Long modifyUserId;
    private Date modifyDate;

}
