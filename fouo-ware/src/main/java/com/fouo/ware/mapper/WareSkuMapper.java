package com.fouo.ware.mapper;

import com.fouo.ware.entity.WareSku;
import com.fouo.ware.vo.WareSkuVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 商品库存 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface WareSkuMapper extends BaseMapper<WareSku> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param wareSku
	 * @return
	 */
	List<WareSkuVO> selectWareSkuPage(IPage page, WareSkuVO wareSku);

	/**
	 * 添加库存
	 * @param skuId
	 * @param wareId
	 * @param skuNum
	 */
    void addStock(Long skuId, Long wareId, Integer skuNum);

	/**
	 * 查询库存总量
	 * @param skuId
	 * @return
	 */
	Long selectSkuStock(Long skuId);
}
