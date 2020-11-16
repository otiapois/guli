package com.fouo.member.service;

import com.fouo.member.entity.GrowthChangeHistory;
import com.fouo.member.vo.GrowthChangeHistoryVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 成长值变化历史记录 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IGrowthChangeHistoryService extends IService<GrowthChangeHistory> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param growthChangeHistory
	 * @return
	 */
	IPage<GrowthChangeHistoryVO> selectGrowthChangeHistoryPage(IPage<GrowthChangeHistoryVO> page, GrowthChangeHistoryVO growthChangeHistory);

}
