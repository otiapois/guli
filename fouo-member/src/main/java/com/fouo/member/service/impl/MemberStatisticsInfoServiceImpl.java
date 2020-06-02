package com.fouo.member.service.impl;

import com.fouo.member.entity.MemberStatisticsInfo;
import com.fouo.member.vo.MemberStatisticsInfoVO;
import com.fouo.member.mapper.MemberStatisticsInfoMapper;
import com.fouo.member.service.IMemberStatisticsInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 会员统计信息 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class MemberStatisticsInfoServiceImpl extends ServiceImpl<MemberStatisticsInfoMapper, MemberStatisticsInfo> implements IMemberStatisticsInfoService {

	@Override
	public IPage<MemberStatisticsInfoVO> selectMemberStatisticsInfoPage(IPage<MemberStatisticsInfoVO> page, MemberStatisticsInfoVO memberStatisticsInfo) {
		return page.setRecords(baseMapper.selectMemberStatisticsInfoPage(page, memberStatisticsInfo));
	}

}
