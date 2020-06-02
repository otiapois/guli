package com.fouo.member.vo;

import com.fouo.member.entity.MemberCollectSubject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 会员收藏的专题活动视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "MemberCollectSubjectVO对象", description = "会员收藏的专题活动")
public class MemberCollectSubjectVO extends MemberCollectSubject {
	private static final long serialVersionUID = 1L;

}
