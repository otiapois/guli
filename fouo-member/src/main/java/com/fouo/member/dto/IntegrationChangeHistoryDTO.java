package com.fouo.member.dto;

import com.fouo.member.entity.IntegrationChangeHistory;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 积分变化历史记录数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class IntegrationChangeHistoryDTO extends IntegrationChangeHistory {
	private static final long serialVersionUID = 1L;

}
