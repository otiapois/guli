package com.fouo.member.mapper;

import com.fouo.member.entity.GrowthChangeHistory;
import com.fouo.member.vo.GrowthChangeHistoryVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 成长值变化历史记录 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface GrowthChangeHistoryMapper extends BaseMapper<GrowthChangeHistory> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param growthChangeHistory
	 * @return
	 */
	List<GrowthChangeHistoryVO> selectGrowthChangeHistoryPage(IPage page, GrowthChangeHistoryVO growthChangeHistory);

}
