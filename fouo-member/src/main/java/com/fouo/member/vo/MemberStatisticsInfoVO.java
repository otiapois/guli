package com.fouo.member.vo;

import com.fouo.member.entity.MemberStatisticsInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 会员统计信息视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "MemberStatisticsInfoVO对象", description = "会员统计信息")
public class MemberStatisticsInfoVO extends MemberStatisticsInfo {
	private static final long serialVersionUID = 1L;

}
