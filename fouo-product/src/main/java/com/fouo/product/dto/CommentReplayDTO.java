package com.fouo.product.dto;

import com.fouo.product.entity.CommentReplay;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品评价回复关系数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CommentReplayDTO extends CommentReplay {
	private static final long serialVersionUID = 1L;

}
