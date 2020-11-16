package com.fouo.coupon.dto;

import com.fouo.coupon.entity.HomeSubject;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class HomeSubjectDTO extends HomeSubject {
	private static final long serialVersionUID = 1L;

}
