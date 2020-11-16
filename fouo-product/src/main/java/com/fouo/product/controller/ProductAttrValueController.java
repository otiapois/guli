package com.fouo.product.controller;

import com.fouo.common.support.Condition;
import com.fouo.common.support.Query;
import com.fouo.common.support.R;
import com.fouo.common.utils.Func;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.product.entity.ProductAttrValue;
import com.fouo.product.vo.ProductAttrValueVO;
import com.fouo.product.service.IProductAttrValueService;

import java.util.ArrayList;
import java.util.List;

/**
 * spu属性值 控制器
 *
 * @author fouo
 * @since 2020-06-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/product/productattrvalue")
@Api(value = "spu属性值", tags = "spu属性值接口")
public class ProductAttrValueController {

    private IProductAttrValueService productAttrValueService;

    @GetMapping("/stringlist/{skuId}")
    public List<String> getSkuSaleAttrValues(@PathVariable("skuId") Long skuId) {
        List<String> list = productAttrValueService.getSkuSaleAttrValues(skuId);
        return list;
    }

    /**
     * 详情
     */
    @GetMapping("/detail")
    @ApiOperation(value = "详情", notes = "传入productAttrValue")
    public R<ProductAttrValue> detail(ProductAttrValue productAttrValue) {
        ProductAttrValue detail = productAttrValueService.getOne(Condition.getQueryWrapper(productAttrValue));
        return R.data(detail);
    }

    /**
     * 分页 spu属性值
     */
    @GetMapping("/list")
    @ApiOperation(value = "分页", notes = "传入productAttrValue")
    public R<IPage<ProductAttrValue>> list(ProductAttrValue productAttrValue, Query query) {
        IPage<ProductAttrValue> pages = productAttrValueService.page(Condition.getPage(query), Condition.getQueryWrapper(productAttrValue));
        return R.data(pages);
    }

    /**
     * 自定义分页 spu属性值
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页", notes = "传入productAttrValue")
    public R<IPage<ProductAttrValueVO>> page(ProductAttrValueVO productAttrValue, Query query) {
        IPage<ProductAttrValueVO> pages = productAttrValueService.selectProductAttrValuePage(Condition.getPage(query), productAttrValue);
        return R.data(pages);
    }

    /**
     * 新增 spu属性值
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增", notes = "传入productAttrValue")
    public R save(@Valid @RequestBody ProductAttrValue productAttrValue) {
        return R.status(productAttrValueService.save(productAttrValue));
    }

    /**
     * 修改 spu属性值
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改", notes = "传入productAttrValue")
    public R update(@Valid @RequestBody ProductAttrValue productAttrValue) {
        return R.status(productAttrValueService.updateById(productAttrValue));
    }

    /**
     * 新增或修改 spu属性值
     */
    @PostMapping("/submit")
    @ApiOperation(value = "新增或修改", notes = "传入productAttrValue")
    public R submit(@Valid @RequestBody ProductAttrValue productAttrValue) {
        return R.status(productAttrValueService.saveOrUpdate(productAttrValue));
    }


    /**
     * 删除 spu属性值
     */
    @PostMapping("/remove")
    @ApiOperation(value = "删除", notes = "传入ids")
    public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
        return R.status(productAttrValueService.removeByIds(Func.toLongList(ids)));
    }


}
