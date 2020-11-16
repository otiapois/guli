package com.fouo.ware.vo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ItemVO {
    private Long itemId;
    private Integer status;
    private String reason;
}
