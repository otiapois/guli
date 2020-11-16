package com.fouo.search.controller;


import com.fouo.common.support.Condition;
import com.fouo.common.support.R;
import com.fouo.common.to.es.SkuEsModel;
import com.fouo.common.utils.Func;
import com.fouo.search.service.IProductSaveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * es 数据保存
 *
 * @author fouo
 * @date 2020/7/27 11:25
 */
@RestController
@AllArgsConstructor
@RequestMapping("/elasticsearch/save")
@Api(value = "es数据", tags = "ES数据保存接口")
public class ElasticSaveController {

    @Autowired
    private IProductSaveService saveService;

    /**
     * 上架商品
     */
    @PostMapping("/product")
    @ApiOperation(value = "商品上架", notes = "传入list<SkuEsModel>")
    public R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels) {
        boolean flag = false;
        try {
            flag = saveService.productStatusUp(skuEsModels);
        }catch (Exception e){
            return R.fail("商品上架失败！");
        }
        return R.status(flag);
    }


}
