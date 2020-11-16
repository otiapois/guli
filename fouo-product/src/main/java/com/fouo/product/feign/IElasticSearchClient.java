package com.fouo.product.feign;

import com.fouo.common.constant.CommonConstant;
import com.fouo.common.support.R;
import com.fouo.common.to.es.SkuEsModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * es 远程调用
 *
 * @author fouo
 * @date 2020/7/27 14:44
 */
@FeignClient(value = CommonConstant.APPLICATION_ELASTICSEARCH_NAME, fallback = IElasticSearchFallback.class)
public interface IElasticSearchClient {

    @PostMapping("/elasticsearch/save/product")
    public R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels);
}