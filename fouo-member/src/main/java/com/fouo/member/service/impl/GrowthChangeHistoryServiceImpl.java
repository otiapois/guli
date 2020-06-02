package com.fouo.member.service.impl;

import com.fouo.member.entity.GrowthChangeHistory;
import com.fouo.member.vo.GrowthChangeHistoryVO;
import com.fouo.member.mapper.GrowthChangeHistoryMapper;
import com.fouo.member.service.IGrowthChangeHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 成长值变化历史记录 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class GrowthChangeHistoryServiceImpl extends ServiceImpl<GrowthChangeHistoryMapper, GrowthChangeHistory> implements IGrowthChangeHistoryService {

	@Override
	public IPage<GrowthChangeHistoryVO> selectGrowthChangeHistoryPage(IPage<GrowthChangeHistoryVO> page, GrowthChangeHistoryVO growthChangeHistory) {
		return page.setRecords(baseMapper.selectGrowthChangeHistoryPage(page, growthChangeHistory));
	}

}
