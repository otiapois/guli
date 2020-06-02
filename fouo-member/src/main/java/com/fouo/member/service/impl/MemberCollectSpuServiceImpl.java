package com.fouo.member.service.impl;

import com.fouo.member.entity.MemberCollectSpu;
import com.fouo.member.vo.MemberCollectSpuVO;
import com.fouo.member.mapper.MemberCollectSpuMapper;
import com.fouo.member.service.IMemberCollectSpuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 会员收藏的商品 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class MemberCollectSpuServiceImpl extends ServiceImpl<MemberCollectSpuMapper, MemberCollectSpu> implements IMemberCollectSpuService {

	@Override
	public IPage<MemberCollectSpuVO> selectMemberCollectSpuPage(IPage<MemberCollectSpuVO> page, MemberCollectSpuVO memberCollectSpu) {
		return page.setRecords(baseMapper.selectMemberCollectSpuPage(page, memberCollectSpu));
	}

}
