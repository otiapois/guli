package com.fouo.ware.service.impl;

import com.fouo.ware.entity.WareOrderTask;
import com.fouo.ware.vo.WareOrderTaskVO;
import com.fouo.ware.mapper.WareOrderTaskMapper;
import com.fouo.ware.service.IWareOrderTaskService;
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
public class WareOrderTaskServiceImpl extends ServiceImpl<WareOrderTaskMapper, WareOrderTask> implements IWareOrderTaskService {

	@Override
	public IPage<WareOrderTaskVO> selectWareOrderTaskPage(IPage<WareOrderTaskVO> page, WareOrderTaskVO wareOrderTask) {
		return page.setRecords(baseMapper.selectWareOrderTaskPage(page, wareOrderTask));
	}

}
