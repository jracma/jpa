package cn.wntime.jpa.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel
public class BaseEntity {


    @CreatedBy
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Long createUserId;

    @CreatedDate
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Date createDate;

    @LastModifiedBy
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Long modifyUserId;

    @LastModifiedDate
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Date modifyDate;

    @Version
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Integer version;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Boolean deleted;

}
