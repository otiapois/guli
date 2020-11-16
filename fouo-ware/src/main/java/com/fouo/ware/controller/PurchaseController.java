package com.fouo.ware.controller;

import com.fouo.common.support.Condition;
import com.fouo.common.support.Query;
import com.fouo.common.support.R;
import com.fouo.common.utils.Func;
import com.fouo.ware.vo.PurchaseDoneVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.ware.entity.Purchase;
import com.fouo.ware.vo.PurchaseVO;
import com.fouo.ware.service.IPurchaseService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 采购信息 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/ware/purchase")
@Api(value = "采购信息", tags = "采购信息接口")
public class PurchaseController {

    private IPurchaseService purchaseService;

    /**
     * 详情
     */
    @GetMapping("/detail")
    @ApiOperation(value = "详情", notes = "传入purchase")
    public R<Purchase> detail(Purchase purchase) {
        Purchase detail = purchaseService.getOne(Condition.getQueryWrapper(purchase));
        return R.data(detail);
    }

    /**
     * 分页 采购信息
     */
    @GetMapping("/list")
    @ApiOperation(value = "分页", notes = "传入purchase")
    public R<IPage<Purchase>> list(Purchase purchase, Query query) {
        IPage<Purchase> pages = purchaseService.page(Condition.getPage(query), Condition.getQueryWrapper(purchase));
        return R.data(pages);
    }

    /**
     * 自定义分页 采购信息
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页", notes = "传入purchase")
    public R<IPage<PurchaseVO>> page(PurchaseVO purchase, Query query) {
        IPage<PurchaseVO> pages = purchaseService.selectPurchasePage(Condition.getPage(query), purchase);
        return R.data(pages);
    }

    /**
     * 采购人员领取采购单
     */
    @PostMapping("/received")
    @ApiOperation(value = "flag", notes = "数组")
    public R received(@RequestBody List<Long> ids) {
        return R.status(purchaseService.received(ids));
    }
	/**
	 * 完成采购单
	 */
	@PostMapping("/done")
	@ApiOperation(value = "flag", notes = "数组")
	public R finish(@RequestBody PurchaseDoneVO doneVO) {
		return R.status(purchaseService.done(doneVO));
	}
    /**
     * 获取未领取的采购单
     */
    @GetMapping("/unreceive/page")
    @ApiOperation(value = "分页", notes = "传入purchase")
    public R<IPage<PurchaseVO>> unreceivePage(PurchaseVO purchase, Query query) {
        IPage<PurchaseVO> pages = purchaseService.selectUnreceivePurchasePage(Condition.getPage(query), purchase);
        return R.data(pages);
    }

    /**
     * 合并采购需求
     */
    @PostMapping("/merge")
    @ApiOperation(value = "分页", notes = "传入purchase")
    public R merge(@RequestBody PurchaseVO merge) {
        return R.status(purchaseService.mergePurchase(merge));
    }


    /**
     * 新增 采购信息
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增", notes = "传入purchase")
    public R save(@Valid @RequestBody Purchase purchase) {
        purchase.setCreateTime(LocalDateTime.now());
        purchase.setUpdateTime(LocalDateTime.now());
        return R.status(purchaseService.save(purchase));
    }

    /**
     * 修改 采购信息
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改", notes = "传入purchase")
    public R update(@Valid @RequestBody Purchase purchase) {
        return R.status(purchaseService.updateById(purchase));
    }

    /**
     * 新增或修改 采购信息
     */
    @PostMapping("/submit")
    @ApiOperation(value = "新增或修改", notes = "传入purchase")
    public R submit(@Valid @RequestBody Purchase purchase) {
        return R.status(purchaseService.saveOrUpdate(purchase));
    }


    /**
     * 删除 采购信息
     */
    @PostMapping("/remove")
    @ApiOperation(value = "删除", notes = "传入ids")
    public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
        return R.status(purchaseService.removeByIds(Func.toLongList(ids)));
    }


}
