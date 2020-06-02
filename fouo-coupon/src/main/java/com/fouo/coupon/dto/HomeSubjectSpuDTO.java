package com.fouo.coupon.dto;

import com.fouo.coupon.entity.HomeSubjectSpu;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 专题商品数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class HomeSubjectSpuDTO extends HomeSubjectSpu {
	private static final long serialVersionUID = 1L;

}
