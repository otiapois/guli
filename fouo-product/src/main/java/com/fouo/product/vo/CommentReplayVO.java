package com.fouo.product.vo;

import com.fouo.product.entity.CommentReplay;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品评价回复关系视图实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "CommentReplayVO对象", description = "商品评价回复关系")
public class CommentReplayVO extends CommentReplay {
	private static final long serialVersionUID = 1L;

}
