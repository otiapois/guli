package com.fouo.member.vo;

import com.fouo.member.entity.MemberCollectSpu;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 会员收藏的商品视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "MemberCollectSpuVO对象", description = "会员收藏的商品")
public class MemberCollectSpuVO extends MemberCollectSpu {
	private static final long serialVersionUID = 1L;

}
