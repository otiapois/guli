package com.fouo.member.dto;

import com.fouo.member.entity.GrowthChangeHistory;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 成长值变化历史记录数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GrowthChangeHistoryDTO extends GrowthChangeHistory {
	private static final long serialVersionUID = 1L;

}
