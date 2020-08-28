package com.fouo.search.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fouo.common.to.es.SkuEsModel;
import com.fouo.search.config.ElasticSearchConfig;
import com.fouo.search.constant.EsConstant;
import com.fouo.search.mapper.ProductSaveMapper;
import com.fouo.search.service.IProductSaveService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContent;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
class ProductSaveServiceImpl extends ServiceImpl<ProductSaveMapper, SkuEsModel> implements IProductSaveService {

    @Autowired
    private RestHighLevelClient client;

    @Override
    public boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException {
        Gson gson = new Gson();
        //将数据保存到es中
        BulkRequest bulkRequest = new BulkRequest();
        for (SkuEsModel model : skuEsModels) {
            //构造保存请求
            IndexRequest indexRequest = new IndexRequest(EsConstant.PRODUCT_INDEX);
            indexRequest.id(model.getSkuId().toString());
            String modelJson = gson.toJson(model);
            indexRequest.source(modelJson, XContentType.JSON);
            bulkRequest.add(indexRequest);
        }
        //批量执行索引数据操作
        BulkResponse bulk = client.bulk(bulkRequest, ElasticSearchConfig.COMMON_OPTIONS);

        List<String> collect = Arrays.stream(bulk.getItems()).map(item -> {
            return item.getId();
        }).collect(Collectors.toList());

//        log.error("商品上架错误：{}",collect);
        boolean flag = bulk.hasFailures();
        return !flag;
    }
}
