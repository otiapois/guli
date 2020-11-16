package com.fouo.coupon.vo;

import com.fouo.coupon.entity.HomeSubject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "HomeSubjectVO对象", description = "首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】")
public class HomeSubjectVO extends HomeSubject {
	private static final long serialVersionUID = 1L;

}
