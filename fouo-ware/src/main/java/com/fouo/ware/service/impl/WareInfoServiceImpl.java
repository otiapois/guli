package com.fouo.ware.service.impl;

import com.fouo.ware.entity.WareInfo;
import com.fouo.ware.vo.WareInfoVO;
import com.fouo.ware.mapper.WareInfoMapper;
import com.fouo.ware.service.IWareInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 仓库信息 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class WareInfoServiceImpl extends ServiceImpl<WareInfoMapper, WareInfo> implements IWareInfoService {

	@Override
	public IPage<WareInfoVO> selectWareInfoPage(IPage<WareInfoVO> page, WareInfoVO wareInfo) {
		return page.setRecords(baseMapper.selectWareInfoPage(page, wareInfo));
	}

}
