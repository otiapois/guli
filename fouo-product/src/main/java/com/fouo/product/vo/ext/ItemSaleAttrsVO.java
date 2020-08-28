package com.fouo.product.vo.ext;

import lombok.Data;

import java.util.List;

/**
 * 销售属性实体类
 *
 * @author fouo
 * @date 2020/8/14 9:07
 */
@Data
public class ItemSaleAttrsVO {
    private Long attrId;
    private String attrName;
    private String attrValues;
}
