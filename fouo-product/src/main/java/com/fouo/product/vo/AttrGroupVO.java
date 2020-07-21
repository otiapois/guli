package com.fouo.product.vo;

import com.fouo.product.entity.Attr;
import com.fouo.product.entity.AttrGroup;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 属性分组视图实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "AttrGroupVO对象", description = "属性分组")
public class AttrGroupVO extends AttrGroup {
	private static final long serialVersionUID = 1L;
	/**
	 * 关键字
	 */
	@ApiModelProperty(value = "关键字")
	private String searchKeyword;

	/**
	 * 属性id
	 */
	@ApiModelProperty(value = "属性id")
	private Long attrId;

	/**
	 * 分组id
	 */
	@ApiModelProperty(value = "分组id")
	private Long attrGroupId;

	/**
	 * 该分组下属性
	 */
	@ApiModelProperty(value = "分组下属性")
	private List<Attr> attrs;
}
