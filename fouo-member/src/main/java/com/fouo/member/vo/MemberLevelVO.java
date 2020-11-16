package com.fouo.member.vo;

import com.fouo.member.entity.MemberLevel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 会员等级视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "MemberLevelVO对象", description = "会员等级")
public class MemberLevelVO extends MemberLevel {
	private static final long serialVersionUID = 1L;

	/**
	 * 关键字
	 */
	@ApiModelProperty(value = "关键字")
	private String searchKeyword;
}
