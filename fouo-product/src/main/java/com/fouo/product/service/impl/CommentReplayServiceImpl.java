package com.fouo.product.service.impl;

import com.fouo.product.entity.CommentReplay;
import com.fouo.product.vo.CommentReplayVO;
import com.fouo.product.mapper.CommentReplayMapper;
import com.fouo.product.service.ICommentReplayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品评价回复关系 服务实现类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Service
public class CommentReplayServiceImpl extends ServiceImpl<CommentReplayMapper, CommentReplay> implements ICommentReplayService {

	@Override
	public IPage<CommentReplayVO> selectCommentReplayPage(IPage<CommentReplayVO> page, CommentReplayVO commentReplay) {
		return page.setRecords(baseMapper.selectCommentReplayPage(page, commentReplay));
	}

}
