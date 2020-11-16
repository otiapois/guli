package com.fouo.member.dto;

import com.fouo.member.entity.Member;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 会员数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MemberDTO extends Member {
	private static final long serialVersionUID = 1L;

}
