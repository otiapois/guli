package com.fouo.member.mapper;

import com.fouo.member.entity.MemberLevel;
import com.fouo.member.vo.MemberLevelVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 会员等级 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface MemberLevelMapper extends BaseMapper<MemberLevel> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param memberLevel
	 * @return
	 */
	List<MemberLevelVO> selectMemberLevelPage(IPage page, MemberLevelVO memberLevel);

}
