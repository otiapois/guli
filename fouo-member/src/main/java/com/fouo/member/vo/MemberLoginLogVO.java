package com.fouo.member.vo;

import com.fouo.member.entity.MemberLoginLog;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 会员登录记录视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "MemberLoginLogVO对象", description = "会员登录记录")
public class MemberLoginLogVO extends MemberLoginLog {
	private static final long serialVersionUID = 1L;

}
