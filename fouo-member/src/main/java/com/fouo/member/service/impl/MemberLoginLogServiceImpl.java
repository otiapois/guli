package com.fouo.member.service.impl;

import com.fouo.member.entity.MemberLoginLog;
import com.fouo.member.vo.MemberLoginLogVO;
import com.fouo.member.mapper.MemberLoginLogMapper;
import com.fouo.member.service.IMemberLoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 会员登录记录 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class MemberLoginLogServiceImpl extends ServiceImpl<MemberLoginLogMapper, MemberLoginLog> implements IMemberLoginLogService {

	@Override
	public IPage<MemberLoginLogVO> selectMemberLoginLogPage(IPage<MemberLoginLogVO> page, MemberLoginLogVO memberLoginLog) {
		return page.setRecords(baseMapper.selectMemberLoginLogPage(page, memberLoginLog));
	}

}
