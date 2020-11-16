package com.fouo.member.vo;

import com.fouo.member.entity.Member;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 会员视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "MemberVO对象", description = "会员")
public class MemberVO extends Member {
	private static final long serialVersionUID = 1L;

}
