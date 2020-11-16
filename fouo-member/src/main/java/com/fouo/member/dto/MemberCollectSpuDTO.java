package com.fouo.member.dto;

import com.fouo.member.entity.MemberCollectSpu;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 会员收藏的商品数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MemberCollectSpuDTO extends MemberCollectSpu {
	private static final long serialVersionUID = 1L;

}
