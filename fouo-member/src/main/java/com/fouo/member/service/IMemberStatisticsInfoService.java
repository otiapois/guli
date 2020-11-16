package com.fouo.member.service;

import com.fouo.member.entity.MemberStatisticsInfo;
import com.fouo.member.vo.MemberStatisticsInfoVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 会员统计信息 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IMemberStatisticsInfoService extends IService<MemberStatisticsInfo> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param memberStatisticsInfo
	 * @return
	 */
	IPage<MemberStatisticsInfoVO> selectMemberStatisticsInfoPage(IPage<MemberStatisticsInfoVO> page, MemberStatisticsInfoVO memberStatisticsInfo);

}
