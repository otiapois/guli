package com.fouo.product.vo;

import com.fouo.product.entity.SpuComment;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品评价视图实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SpuCommentVO对象", description = "商品评价")
public class SpuCommentVO extends SpuComment {
	private static final long serialVersionUID = 1L;

}
