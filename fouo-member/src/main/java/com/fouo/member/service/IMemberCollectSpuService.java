package com.fouo.member.service;

import com.fouo.member.entity.MemberCollectSpu;
import com.fouo.member.vo.MemberCollectSpuVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 会员收藏的商品 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IMemberCollectSpuService extends IService<MemberCollectSpu> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param memberCollectSpu
	 * @return
	 */
	IPage<MemberCollectSpuVO> selectMemberCollectSpuPage(IPage<MemberCollectSpuVO> page, MemberCollectSpuVO memberCollectSpu);

}
