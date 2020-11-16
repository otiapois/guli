package com.fouo.ware.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PurchaseDoneVO {
    /**
     * 关键字
     */
    @ApiModelProperty(value = "关键字")
    private String searchKeyword;

    @NotNull
    private Long id;//采购单id

    private List<ItemVO> items;



}
