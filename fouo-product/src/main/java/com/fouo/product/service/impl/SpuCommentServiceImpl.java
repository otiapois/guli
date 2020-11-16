package com.fouo.product.service.impl;

import com.fouo.product.entity.SpuComment;
import com.fouo.product.vo.SpuCommentVO;
import com.fouo.product.mapper.SpuCommentMapper;
import com.fouo.product.service.ISpuCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品评价 服务实现类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Service
public class SpuCommentServiceImpl extends ServiceImpl<SpuCommentMapper, SpuComment> implements ISpuCommentService {

	@Override
	public IPage<SpuCommentVO> selectSpuCommentPage(IPage<SpuCommentVO> page, SpuCommentVO spuComment) {
		return page.setRecords(baseMapper.selectSpuCommentPage(page, spuComment));
	}

}
