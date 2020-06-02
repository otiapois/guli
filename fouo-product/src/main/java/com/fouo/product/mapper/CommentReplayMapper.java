package com.fouo.product.mapper;

import com.fouo.product.entity.CommentReplay;
import com.fouo.product.vo.CommentReplayVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 商品评价回复关系 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface CommentReplayMapper extends BaseMapper<CommentReplay> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param commentReplay
	 * @return
	 */
	List<CommentReplayVO> selectCommentReplayPage(IPage page, CommentReplayVO commentReplay);

}
