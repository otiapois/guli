package com.fouo.ware.service.impl;

import com.fouo.ware.entity.WareSku;
import com.fouo.ware.vo.WareSkuVO;
import com.fouo.ware.mapper.WareSkuMapper;
import com.fouo.ware.service.IWareSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品库存 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class WareSkuServiceImpl extends ServiceImpl<WareSkuMapper, WareSku> implements IWareSkuService {

	@Override
	public IPage<WareSkuVO> selectWareSkuPage(IPage<WareSkuVO> page, WareSkuVO wareSku) {
		return page.setRecords(baseMapper.selectWareSkuPage(page, wareSku));
	}

}
