package com.fouo.product.dto;

import com.fouo.product.entity.SpuComment;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品评价数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SpuCommentDTO extends SpuComment {
	private static final long serialVersionUID = 1L;

}
