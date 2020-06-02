package com.fouo.member.dto;

import com.fouo.member.entity.MemberLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 会员等级数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MemberLevelDTO extends MemberLevel {
	private static final long serialVersionUID = 1L;

}
