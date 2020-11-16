package com.fouo.member.mapper;

import com.fouo.member.entity.MemberLoginLog;
import com.fouo.member.vo.MemberLoginLogVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 会员登录记录 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface MemberLoginLogMapper extends BaseMapper<MemberLoginLog> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param memberLoginLog
	 * @return
	 */
	List<MemberLoginLogVO> selectMemberLoginLogPage(IPage page, MemberLoginLogVO memberLoginLog);

}
