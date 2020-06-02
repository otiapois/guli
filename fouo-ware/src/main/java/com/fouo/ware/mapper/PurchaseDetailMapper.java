package com.fouo.ware.mapper;

import com.fouo.ware.entity.PurchaseDetail;
import com.fouo.ware.vo.PurchaseDetailVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 *  Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface PurchaseDetailMapper extends BaseMapper<PurchaseDetail> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param purchaseDetail
	 * @return
	 */
	List<PurchaseDetailVO> selectPurchaseDetailPage(IPage page, PurchaseDetailVO purchaseDetail);

}
