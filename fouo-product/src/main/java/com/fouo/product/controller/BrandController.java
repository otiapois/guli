package com.fouo.product.controller;

import com.fouo.common.support.Condition;
import com.fouo.common.support.Query;
import com.fouo.common.support.R;
import com.fouo.common.support.ResultCode;
import com.fouo.common.utils.Func;
import com.fouo.common.valid.AddGroup;
import com.fouo.common.valid.UpdateGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.product.entity.Brand;
import com.fouo.product.vo.BrandVO;
import com.fouo.product.service.IBrandService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 品牌 控制器
 *
 * @author fouo
 * @since 2020-06-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/product/brand")
@Api(value = "品牌", tags = "品牌接口")
public class BrandController {

    private IBrandService brandService;

    /**
     * 详情
     */
    @GetMapping("/detail")
    @ApiOperation(value = "详情", notes = "传入brand")
    public R<Brand> detail(Brand brand) {
        Brand detail = brandService.getOne(Condition.getQueryWrapper(brand));
        return R.data(detail);
    }

    /**
     * 分页 品牌
     */
    @GetMapping("/list")
    @ApiOperation(value = "分页", notes = "传入brand")
    public R<IPage<Brand>> list(Brand brand, Query query) {
        IPage<Brand> pages = brandService.page(Condition.getPage(query), Condition.getQueryWrapper(brand));
        return R.data(pages);
    }

    /**
     * 自定义分页 品牌
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页", notes = "传入brand")
    public R<IPage<BrandVO>> page(BrandVO brand, Query query) {

        //去除关键词的空格
        if (StringUtils.isBlank(brand.getSearchKeyword())) {
            brand.setSearchKeyword(null);
        }
        IPage<BrandVO> pages = brandService.selectBrandPage(Condition.getPage(query), brand);
        return R.data(pages);
    }

    /**
     * 新增 品牌
     * BindingResult result 是Validation类封装的校验后的结果
     * 用于自定义显示   该结果必须紧跟再被校验的参数之后进行使用
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增", notes = "传入brand")
    public R save(@Validated({AddGroup.class}) @RequestBody Brand brand/*, BindingResult result*/) {
        //判断校验结果是否存在错误
//        if (result.hasErrors()) {
//			Map<String,String> map = new HashMap<>();
//            result.getFieldErrors().forEach((item) -> {
//                //获取错误校验消息
//                String defaultMessage = item.getDefaultMessage();
//                //获取错误字段的字段名称
//				String fileName = item.getField();
//				map.put(fileName,defaultMessage);
//			});
//            return R.data(400 , map,"提交的数据不合法,请检查后重新提交！") ;
//        }

        return R.status(brandService.save(brand));
    }

    /**
     * 修改 品牌
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改", notes = "传入brand")
    public R update(@Validated({UpdateGroup.class}) @RequestBody Brand brand) {
        return R.status(brandService.updateDetail(brand));
    }

    /**
     * 新增或修改 品牌
     */
    @PostMapping("/submit")
    @ApiOperation(value = "新增或修改", notes = "传入brand")
    public R submit(@Valid @RequestBody Brand brand) {
        return R.status(brandService.saveOrUpdate(brand));
    }


    /**
     * 删除 品牌
     */
    @PostMapping("/remove")
    @ApiOperation(value = "删除", notes = "传入ids")
    public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody Long[] ids) {
        return R.status(brandService.removeByIds(Arrays.asList(ids)));
    }

}
