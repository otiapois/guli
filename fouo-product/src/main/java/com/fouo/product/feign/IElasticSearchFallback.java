package com.fouo.product.feign;

import com.fouo.common.support.R;
import com.fouo.common.to.es.SkuEsModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IElasticSearchFallback implements IElasticSearchClient {

    @Override
    public R productStatusUp(List<SkuEsModel> skuEsModels) {
        return R.fail("商品上架失败");
    }
}
