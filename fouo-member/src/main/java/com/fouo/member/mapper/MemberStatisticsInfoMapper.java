package com.fouo.member.mapper;

import com.fouo.member.entity.MemberStatisticsInfo;
import com.fouo.member.vo.MemberStatisticsInfoVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 会员统计信息 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface MemberStatisticsInfoMapper extends BaseMapper<MemberStatisticsInfo> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param memberStatisticsInfo
	 * @return
	 */
	List<MemberStatisticsInfoVO> selectMemberStatisticsInfoPage(IPage page, MemberStatisticsInfoVO memberStatisticsInfo);

}
