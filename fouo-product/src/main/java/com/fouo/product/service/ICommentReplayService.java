package com.fouo.product.service;

import com.fouo.product.entity.CommentReplay;
import com.fouo.product.vo.CommentReplayVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品评价回复关系 服务类
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface ICommentReplayService extends IService<CommentReplay> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param commentReplay
	 * @return
	 */
	IPage<CommentReplayVO> selectCommentReplayPage(IPage<CommentReplayVO> page, CommentReplayVO commentReplay);

}
