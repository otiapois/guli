package com.fouo.member.service;

import com.fouo.member.entity.MemberLevel;
import com.fouo.member.vo.MemberLevelVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 会员等级 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IMemberLevelService extends IService<MemberLevel> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param memberLevel
	 * @return
	 */
	IPage<MemberLevelVO> selectMemberLevelPage(IPage<MemberLevelVO> page, MemberLevelVO memberLevel);

}
