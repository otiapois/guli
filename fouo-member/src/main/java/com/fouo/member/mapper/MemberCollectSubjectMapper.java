package com.fouo.member.mapper;

import com.fouo.member.entity.MemberCollectSubject;
import com.fouo.member.vo.MemberCollectSubjectVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 会员收藏的专题活动 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface MemberCollectSubjectMapper extends BaseMapper<MemberCollectSubject> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param memberCollectSubject
	 * @return
	 */
	List<MemberCollectSubjectVO> selectMemberCollectSubjectPage(IPage page, MemberCollectSubjectVO memberCollectSubject);

}
