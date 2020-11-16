package com.fouo.member.dto;

import com.fouo.member.entity.MemberCollectSubject;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 会员收藏的专题活动数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MemberCollectSubjectDTO extends MemberCollectSubject {
	private static final long serialVersionUID = 1L;

}
