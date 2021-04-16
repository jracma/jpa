package cn.wntime.jpa.domain.common;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedBy
    private Long createUserId;
    
    @CreatedDate
    private Date createDate;

    @LastModifiedBy
    private Long modifyUserId;

    @LastModifiedDate
    private Date modifyDate;

    @Version
    private Integer version;

    private Boolean deleted;

}
