package com.fouo.coupon.vo;

import com.fouo.coupon.entity.HomeSubjectSpu;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 专题商品视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "HomeSubjectSpuVO对象", description = "专题商品")
public class HomeSubjectSpuVO extends HomeSubjectSpu {
	private static final long serialVersionUID = 1L;

}
