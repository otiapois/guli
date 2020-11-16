package com.fouo.member.service.impl;

import com.fouo.member.entity.MemberCollectSubject;
import com.fouo.member.vo.MemberCollectSubjectVO;
import com.fouo.member.mapper.MemberCollectSubjectMapper;
import com.fouo.member.service.IMemberCollectSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 会员收藏的专题活动 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class MemberCollectSubjectServiceImpl extends ServiceImpl<MemberCollectSubjectMapper, MemberCollectSubject> implements IMemberCollectSubjectService {

	@Override
	public IPage<MemberCollectSubjectVO> selectMemberCollectSubjectPage(IPage<MemberCollectSubjectVO> page, MemberCollectSubjectVO memberCollectSubject) {
		return page.setRecords(baseMapper.selectMemberCollectSubjectPage(page, memberCollectSubject));
	}

}
