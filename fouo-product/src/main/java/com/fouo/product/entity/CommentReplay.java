package com.fouo.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商品评价回复关系实体类
 *
 * @author fouo
 * @since 2020-06-01
 */
@Data
@TableName("pms_comment_replay")
@ApiModel(value = "CommentReplay对象", description = "商品评价回复关系")
public class CommentReplay implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
		@ApiModelProperty(value = "id")
		@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* 评论id
	*/
		@ApiModelProperty(value = "评论id")
		private Long commentId;
	/**
	* 回复id
	*/
		@ApiModelProperty(value = "回复id")
		private Long replyId;


}
