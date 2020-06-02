package com.fouo.member.dto;

import com.fouo.member.entity.MemberLoginLog;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 会员登录记录数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MemberLoginLogDTO extends MemberLoginLog {
	private static final long serialVersionUID = 1L;

}
