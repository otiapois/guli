package com.fouo.product.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.common.support.Condition;
import com.fouo.common.support.Query;
import com.fouo.common.support.R;
import com.fouo.product.entity.Brand;
import com.fouo.product.entity.CategoryBrandRelation;
import com.fouo.product.service.ICategoryBrandRelationService;
import com.fouo.product.service.ICategoryService;
import com.fouo.product.vo.CategoryBrandRelationVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * 品牌分类关联 控制器
 *
 * @author fouo
 * @since 2020-06-18
 */
@RestController
@AllArgsConstructor
@RequestMapping("/product/categorybrandrelation")
@Api(value = "品牌&分类关联", tags = "品牌&分类关联接口")
public class CategoryBrandRelationController {
    private ICategoryBrandRelationService categoryBrandRelationService;
    private ICategoryService categoryService;

    /**
     * 详情
     */
    @GetMapping("/detail")
    @ApiOperation(value = "详情", notes = "传入categoryBrandRelation")
    public R<CategoryBrandRelation> detail(CategoryBrandRelation categoryBrandRelation) {
        CategoryBrandRelation detail = categoryBrandRelationService.getOne(Condition.getQueryWrapper(categoryBrandRelation));
        return R.data(detail);
    }

    /**
     * 分页 品牌&分类关联
     */
    @GetMapping("/list")
    @ApiOperation(value = "分页", notes = "传入categoryBrandRelation")
    public R<IPage<CategoryBrandRelation>> list(CategoryBrandRelation categoryBrandRelation, Query query) {
        IPage<CategoryBrandRelation> pages = categoryBrandRelationService.page(Condition.getPage(query), Condition.getQueryWrapper(categoryBrandRelation));
        return R.data(pages);
    }

    /**
     * 获取到当前分类关联的所有品牌
     *
     * @param catId 分类id
     * @return
     */
    @GetMapping("/brands/list")
    @ApiOperation(value = "分页", notes = "传入categoryBrandRelation")
    public R<List<Brand>> relationBrandsList(@RequestParam(value = "catId", required = true) Long catId) {
        List<Brand> brands = categoryBrandRelationService.relationBrandsList(catId);
        return R.data(brands);
    }

    /**
     * 自定义分页 品牌&分类关联
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页", notes = "传入categoryBrandRelation")
    public R<IPage<CategoryBrandRelationVO>> page(CategoryBrandRelationVO categoryBrandRelation, Query query) {
        IPage<CategoryBrandRelationVO> pages = categoryBrandRelationService.selectCategoryBrandRelationPage(Condition.getPage(query), categoryBrandRelation);
        return R.data(pages);
    }

    /**
     * 新增 品牌&分类关联
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增", notes = "传入categoryBrandRelation")
    public R save(@Valid @RequestBody CategoryBrandRelation categoryBrandRelation) {
        return R.status(categoryBrandRelationService.saveDetail(categoryBrandRelation));
    }

    /**
     * 修改 品牌&分类关联
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改", notes = "传入categoryBrandRelation")
    public R update(@Valid @RequestBody CategoryBrandRelation categoryBrandRelation) {
        return R.status(categoryBrandRelationService.updateById(categoryBrandRelation));
    }

    /**
     * 新增或修改 属性&属性分组关联
     */
    @PostMapping("/submit")
    @ApiOperation(value = "新增或修改", notes = "传入categoryBrandRelation")
    public R submit(@Valid @RequestBody CategoryBrandRelation categoryBrandRelation) {
        return R.status(categoryBrandRelationService.saveOrUpdate(categoryBrandRelation));
    }


    /**
     * 删除 属性&属性分组关联
     */
    @PostMapping("/remove")
    @ApiOperation(value = "删除", notes = "传入ids")
    public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody CategoryBrandRelation categoryBrandRelation) {
        return R.status(categoryBrandRelationService.removeById(categoryBrandRelation.getId()));
    }
}
