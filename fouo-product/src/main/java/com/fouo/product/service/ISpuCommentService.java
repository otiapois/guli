package com.fouo.product.service;

import com.fouo.product.entity.SpuComment;
import com.fouo.product.vo.SpuCommentVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品评价 服务类
 *
 * @author fouo
 * @since 2020-06-01
 */
public interface ISpuCommentService extends IService<SpuComment> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param spuComment
	 * @return
	 */
	IPage<SpuCommentVO> selectSpuCommentPage(IPage<SpuCommentVO> page, SpuCommentVO spuComment);

}
