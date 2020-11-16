package com.fouo.member.mapper;

import com.fouo.member.entity.IntegrationChangeHistory;
import com.fouo.member.vo.IntegrationChangeHistoryVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 积分变化历史记录 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IntegrationChangeHistoryMapper extends BaseMapper<IntegrationChangeHistory> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param integrationChangeHistory
	 * @return
	 */
	List<IntegrationChangeHistoryVO> selectIntegrationChangeHistoryPage(IPage page, IntegrationChangeHistoryVO integrationChangeHistory);

}
