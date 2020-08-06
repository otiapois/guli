package com.fouo.product.feign;

import com.fouo.common.support.R;
import com.fouo.common.to.SkuReductionTO;
import com.fouo.product.vo.ext.Bounds;
import com.fouo.product.vo.ext.SkuHasStockV0;

import java.util.List;

public class IWareFallback implements IWareClient{

    @Override
    public R<List<SkuHasStockV0>> getSkusHasStock(List<Long> skuIds) {
        return null;
    }
}
