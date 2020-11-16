package com.fouo.member.vo;

import com.fouo.member.entity.GrowthChangeHistory;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 成长值变化历史记录视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "GrowthChangeHistoryVO对象", description = "成长值变化历史记录")
public class GrowthChangeHistoryVO extends GrowthChangeHistory {
	private static final long serialVersionUID = 1L;

}
