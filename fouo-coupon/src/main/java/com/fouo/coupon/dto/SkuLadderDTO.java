package com.fouo.coupon.dto;

import com.fouo.coupon.entity.SkuLadder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品阶梯价格数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SkuLadderDTO extends SkuLadder {
	private static final long serialVersionUID = 1L;

}
