package com.fouo.cart.feign;

import com.fouo.common.support.R;

import java.util.List;

public class IProductClientFallback implements IProductClient{

    @Override
    public R getSkuBySkuId(Long skuId) {
        return R.fail("商品详情查询失败");
    }

    @Override
    public List<String> getSkuSaleAttrValues(Long skuId) {
        return null;
    }
}
