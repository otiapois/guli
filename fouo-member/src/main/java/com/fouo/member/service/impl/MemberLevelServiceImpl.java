package com.fouo.member.service.impl;

import com.fouo.member.entity.MemberLevel;
import com.fouo.member.vo.MemberLevelVO;
import com.fouo.member.mapper.MemberLevelMapper;
import com.fouo.member.service.IMemberLevelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 会员等级 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class MemberLevelServiceImpl extends ServiceImpl<MemberLevelMapper, MemberLevel> implements IMemberLevelService {

	@Override
	public IPage<MemberLevelVO> selectMemberLevelPage(IPage<MemberLevelVO> page, MemberLevelVO memberLevel) {
		return page.setRecords(baseMapper.selectMemberLevelPage(page, memberLevel));
	}

}
