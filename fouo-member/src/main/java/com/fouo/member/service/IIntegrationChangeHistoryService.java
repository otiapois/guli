package com.fouo.member.service;

import com.fouo.member.entity.IntegrationChangeHistory;
import com.fouo.member.vo.IntegrationChangeHistoryVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 积分变化历史记录 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IIntegrationChangeHistoryService extends IService<IntegrationChangeHistory> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param integrationChangeHistory
	 * @return
	 */
	IPage<IntegrationChangeHistoryVO> selectIntegrationChangeHistoryPage(IPage<IntegrationChangeHistoryVO> page, IntegrationChangeHistoryVO integrationChangeHistory);

}
