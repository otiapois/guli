package com.fouo.member.mapper;

import com.fouo.member.entity.MemberCollectSpu;
import com.fouo.member.vo.MemberCollectSpuVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 会员收藏的商品 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface MemberCollectSpuMapper extends BaseMapper<MemberCollectSpu> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param memberCollectSpu
	 * @return
	 */
	List<MemberCollectSpuVO> selectMemberCollectSpuPage(IPage page, MemberCollectSpuVO memberCollectSpu);

}
