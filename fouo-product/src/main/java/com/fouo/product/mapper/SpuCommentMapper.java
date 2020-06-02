package com.fouo.product.mapper;

import com.fouo.product.entity.SpuComment;
import com.fouo.product.vo.SpuCommentVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 商品评价 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface SpuCommentMapper extends BaseMapper<SpuComment> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param spuComment
	 * @return
	 */
	List<SpuCommentVO> selectSpuCommentPage(IPage page, SpuCommentVO spuComment);

}
