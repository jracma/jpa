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
    @ApiModelProperty(hidden = true)
    private String createBy;

    @CreatedDate
    @ApiModelProperty(hidden = true)
    private Date createDate;

    @LastModifiedBy
    @ApiModelProperty(hidden = true)
    private String modifyBy;

    @LastModifiedDate
    @ApiModelProperty(hidden = true)
    private Date modifyDate;

    @Version
    @ApiModelProperty(hidden = true)
    private Integer version;

    @ApiModelProperty(hidden = true)
    private Boolean deleted=false;

}
