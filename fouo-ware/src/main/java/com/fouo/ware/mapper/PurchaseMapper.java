package com.fouo.ware.mapper;

import com.fouo.ware.entity.Purchase;
import com.fouo.ware.vo.PurchaseVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 采购信息 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface PurchaseMapper extends BaseMapper<Purchase> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param purchase
	 * @return
	 */
	List<PurchaseVO> selectPurchasePage(IPage page, PurchaseVO purchase);

}
