package com.fouo.member.service;

import com.fouo.member.entity.MemberLoginLog;
import com.fouo.member.vo.MemberLoginLogVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 会员登录记录 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IMemberLoginLogService extends IService<MemberLoginLog> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param memberLoginLog
	 * @return
	 */
	IPage<MemberLoginLogVO> selectMemberLoginLogPage(IPage<MemberLoginLogVO> page, MemberLoginLogVO memberLoginLog);

}
