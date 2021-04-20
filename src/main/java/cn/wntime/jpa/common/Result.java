package cn.wntime.jpa.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 返回数据
 *
 */
@Data
@ApiModel(description="返回的响应对象")
public class Result<T> implements Serializable {
	private static final long serialVersionUID = -1243837890442299554L;

	@ApiModelProperty(value = "返回码",name = "code",notes = "0 代表成功")
	private int code;

	@ApiModelProperty(value = "返回消息",name = "message")
	private String message;

	@ApiModelProperty(value = "返回数据",name = "data")
	private T data;

}
