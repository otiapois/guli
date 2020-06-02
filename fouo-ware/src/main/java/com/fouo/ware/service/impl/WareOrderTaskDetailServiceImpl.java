package com.fouo.ware.service.impl;

import com.fouo.ware.entity.WareOrderTaskDetail;
import com.fouo.ware.vo.WareOrderTaskDetailVO;
import com.fouo.ware.mapper.WareOrderTaskDetailMapper;
import com.fouo.ware.service.IWareOrderTaskDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 库存工作单 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class WareOrderTaskDetailServiceImpl extends ServiceImpl<WareOrderTaskDetailMapper, WareOrderTaskDetail> implements IWareOrderTaskDetailService {

	@Override
	public IPage<WareOrderTaskDetailVO> selectWareOrderTaskDetailPage(IPage<WareOrderTaskDetailVO> page, WareOrderTaskDetailVO wareOrderTaskDetail) {
		return page.setRecords(baseMapper.selectWareOrderTaskDetailPage(page, wareOrderTaskDetail));
	}

}
