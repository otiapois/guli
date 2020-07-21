package com.fouo.ware.service;

import com.fouo.ware.entity.WareSku;
import com.fouo.ware.vo.WareSkuVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品库存 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IWareSkuService extends IService<WareSku> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param wareSku
	 * @return
	 */
	IPage<WareSkuVO> selectWareSkuPage(IPage<WareSkuVO> page, WareSkuVO wareSku);

	/**
	 * 添加库存
	 * @param skuId
	 * @param wareId
	 * @param skuNum
	 */
    void addStock(Long skuId, Long wareId, Integer skuNum);
}
