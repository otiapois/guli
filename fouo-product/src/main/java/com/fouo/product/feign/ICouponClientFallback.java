package com.fouo.product.feign;

import com.fouo.common.support.R;
import com.fouo.common.to.SkuReductionTO;
import com.fouo.product.vo.ext.Bounds;
import org.springframework.stereotype.Component;

@Component
public class ICouponClientFallback implements ICouponClient{
    @Override
    public R saveSpuBounds(Bounds bounds) {
        return R.fail( "保存数据失败" );
    }

    @Override
    public R saveSkuReduction(SkuReductionTO skuReductionTO) {
        return R.fail( "保存数据失败" );
    }
//    @Override
//    public R<Coupon> testFeign() {
//        return R.fail( "获取数据失败" );
//    }
}
