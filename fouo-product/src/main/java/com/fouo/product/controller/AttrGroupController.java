package com.fouo.product.controller;

import com.fouo.common.support.Condition;
import com.fouo.common.support.Query;
import com.fouo.common.support.R;
import com.fouo.common.utils.Func;
import com.fouo.product.entity.Attr;
import com.fouo.product.entity.AttrAttrgroupRelation;
import com.fouo.product.service.IAttrAttrgroupRelationService;
import com.fouo.product.service.IAttrService;
import com.fouo.product.service.ICategoryService;
import com.fouo.product.vo.AttrAttrgroupRelationVO;
import com.fouo.product.vo.AttrVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.product.entity.AttrGroup;
import com.fouo.product.vo.AttrGroupVO;
import com.fouo.product.service.IAttrGroupService;

import java.util.Arrays;
import java.util.List;

/**
 * 属性分组 控制器
 *
 * @author fouo
 * @since 2020-06-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/product/attrgroup")
@Api(value = "属性分组", tags = "属性分组接口")
public class AttrGroupController {

    private IAttrGroupService attrGroupService;

    private ICategoryService categoryService;

    private IAttrService attrService;

    private IAttrAttrgroupRelationService attrAttrgroupRelationService;

    /**
     * 详情
     */
    @GetMapping("/detail")
    @ApiOperation(value = "详情", notes = "传入attrGroup")
    public R<AttrGroup> detail(AttrGroup attrGroup) {
        AttrGroup detail = attrGroupService.getOne(Condition.getQueryWrapper(attrGroup));
        //设置当前id下的菜单的全路径
        Long[] catelogPath = categoryService.searchCatelogPath(detail.getCatelogId());
        //设置全路径 [1、23、126] 三级菜单的每级id的数组
        detail.setCatelogPath(catelogPath);
        return R.data(detail);
    }

    /**
     * 分页 属性分组
     */
    @GetMapping("/list")
    @ApiOperation(value = "分页", notes = "传入attrGroup")
    public R<IPage<AttrGroup>> list(AttrGroup attrGroup, Query query) {
        IPage<AttrGroup> pages = attrGroupService.page(Condition.getPage(query), Condition.getQueryWrapper(attrGroup));
        return R.data(pages);
    }

    /**
     * 自定义分页 属性分组
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页", notes = "传入attrGroup")
    public R<IPage<AttrGroupVO>> page(AttrGroupVO attrGroup, Query query) {
        //去除关键词的空格
        if (StringUtils.isBlank(attrGroup.getSearchKeyword())) {
            attrGroup.setSearchKeyword(null);
        }
        IPage<AttrGroupVO> pages = attrGroupService.selectAttrGroupPage(Condition.getPage(query), attrGroup);
        return R.data(pages);
    }

    /**
     * 新增 属性分组
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增", notes = "传入attrGroup")
    public R save(@Valid @RequestBody AttrGroup attrGroup) {
        return R.status(attrGroupService.save(attrGroup));
    }

    /**
     * 修改 属性分组
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改", notes = "传入attrGroup")
    public R update(@Valid @RequestBody AttrGroup attrGroup) {
        return R.status(attrGroupService.updateById(attrGroup));
    }

    /**
     * 新增或修改 属性分组
     */
    @PostMapping("/submit")
    @ApiOperation(value = "新增或修改", notes = "传入attrGroup")
    public R submit(@Valid @RequestBody AttrGroup attrGroup) {
        return R.status(attrGroupService.saveOrUpdate(attrGroup));
    }


    /**
     * 删除 属性分组
     */
    @PostMapping("/remove")
    @ApiOperation(value = "删除", notes = "传入ids")
    public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody Long[] ids) {
        return R.status(attrGroupService.removeByIds(Arrays.asList(ids)));
    }

    /**
     * 获取分组所关联的属性列表
     */
    @GetMapping("/attr/relation")
    @ApiOperation(value = "获取分组关联属性", notes = "传入分组id")
    public R relation(@RequestParam Long attrGroupId) {
        //获取当前分组关联的所有属性集合
        List<Attr> list = attrService.getRelationAttr(attrGroupId);
        return R.data(list);
    }
    /**
     * 移除属性和分组的关联关系
     */
    @PostMapping("/attr/relation/remove")
    public R removeRelation(@Valid @RequestBody AttrGroupVO attrGroupVO){
        return R.status(attrAttrgroupRelationService.removeRelation(attrGroupVO.getAttrId(),attrGroupVO.getAttrGroupId()));
    }

    /**
     * 新增属性和分组的关联关系
     */
    @PostMapping("/attr/relation/add")
    public R addRelationBatch(@Valid @RequestBody List<AttrAttrgroupRelationVO> list){
        return R.status(attrAttrgroupRelationService.addRelationBatch(list));
    }
    /**
     * 批量删除
     * 移除属性和分组的关联关系
     */
    @PostMapping("/attr/relation/removeBatch")
    public R removeRelationBatch(@Valid @RequestBody List<AttrGroupVO> list){
        return R.status(attrAttrgroupRelationService.removeRelationBatch(list));
    }

    /**
     * 获取属性分组没有关联的其他属性
     */
    @GetMapping("/noattr/relation")
    public  R<IPage<Attr>> notRelation(AttrGroupVO attrGroupVO, Query query){
        //去除关键词的空格
        if (StringUtils.isBlank(attrGroupVO.getSearchKeyword())) {
            attrGroupVO.setSearchKeyword(null);
        }
        IPage<Attr> pages = attrGroupService.selectNotRelation(Condition.getPage(query), attrGroupVO);
        return R.data(pages);
    }

    /**
     * 根据分类id获取相应的所有分组及其下面的属性
     * @param catalogId
     * @return
     */
    @GetMapping("/withattr")
    public R<List<AttrGroupVO>> getAttrGroupWithAttrs(@RequestParam Long catalogId){
        return R.data(attrGroupService.getAttrGroupWithAttrs(catalogId));
    }
}
