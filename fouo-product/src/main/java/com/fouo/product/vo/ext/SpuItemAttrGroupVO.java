package com.fouo.product.vo.ext;

import lombok.Data;

import java.util.List;

/**
 * 商品基本属性
 *
 * @author fouo
 * @date 2020/8/14 9:11
 */
@Data
public class SpuItemAttrGroupVO {
    private String groupName;
    private List<SpuBaseAttrVO> attrs;

}


