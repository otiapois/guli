package com.fouo.member.dto;

import com.fouo.member.entity.MemberStatisticsInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 会员统计信息数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MemberStatisticsInfoDTO extends MemberStatisticsInfo {
	private static final long serialVersionUID = 1L;

}
