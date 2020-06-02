package com.fouo.ware.service.impl;

import com.fouo.ware.entity.Purchase;
import com.fouo.ware.vo.PurchaseVO;
import com.fouo.ware.mapper.PurchaseMapper;
import com.fouo.ware.service.IPurchaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 采购信息 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements IPurchaseService {

	@Override
	public IPage<PurchaseVO> selectPurchasePage(IPage<PurchaseVO> page, PurchaseVO purchase) {
		return page.setRecords(baseMapper.selectPurchasePage(page, purchase));
	}

}
