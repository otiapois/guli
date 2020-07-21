package com.fouo.ware.vo;

import com.fouo.ware.entity.WareInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 仓库信息视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "WareInfoVO对象", description = "仓库信息")
public class WareInfoVO extends WareInfo {
	private static final long serialVersionUID = 1L;
	/**
	 * 关键字
	 */
	@ApiModelProperty(value = "关键字")
	private String searchKeyword;
}
