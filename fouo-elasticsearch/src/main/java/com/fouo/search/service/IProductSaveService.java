package com.fouo.search.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.fouo.common.to.es.SkuEsModel;

import java.io.IOException;
import java.util.List;


/**
 *  服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IProductSaveService extends IService<SkuEsModel> {


    /**
     * 商品上架
     * @param skuEsModels
     * @return
     */
    boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException;
}
