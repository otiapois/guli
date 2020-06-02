package com.fouo.member.service;

import com.fouo.member.entity.MemberCollectSubject;
import com.fouo.member.vo.MemberCollectSubjectVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 会员收藏的专题活动 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IMemberCollectSubjectService extends IService<MemberCollectSubject> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param memberCollectSubject
	 * @return
	 */
	IPage<MemberCollectSubjectVO> selectMemberCollectSubjectPage(IPage<MemberCollectSubjectVO> page, MemberCollectSubjectVO memberCollectSubject);

}
