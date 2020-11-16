package com.fouo.member.service.impl;

import com.fouo.member.entity.IntegrationChangeHistory;
import com.fouo.member.vo.IntegrationChangeHistoryVO;
import com.fouo.member.mapper.IntegrationChangeHistoryMapper;
import com.fouo.member.service.IIntegrationChangeHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 积分变化历史记录 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class IntegrationChangeHistoryServiceImpl extends ServiceImpl<IntegrationChangeHistoryMapper, IntegrationChangeHistory> implements IIntegrationChangeHistoryService {

	@Override
	public IPage<IntegrationChangeHistoryVO> selectIntegrationChangeHistoryPage(IPage<IntegrationChangeHistoryVO> page, IntegrationChangeHistoryVO integrationChangeHistory) {
		return page.setRecords(baseMapper.selectIntegrationChangeHistoryPage(page, integrationChangeHistory));
	}

}
