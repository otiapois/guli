package com.fouo.member.vo;

import com.fouo.member.entity.IntegrationChangeHistory;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 积分变化历史记录视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "IntegrationChangeHistoryVO对象", description = "积分变化历史记录")
public class IntegrationChangeHistoryVO extends IntegrationChangeHistory {
	private static final long serialVersionUID = 1L;

}
