package com.fouo.ware.service;

import com.fouo.ware.entity.WareOrderTask;
import com.fouo.ware.vo.WareOrderTaskVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 库存工作单 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IWareOrderTaskService extends IService<WareOrderTask> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param wareOrderTask
	 * @return
	 */
	IPage<WareOrderTaskVO> selectWareOrderTaskPage(IPage<WareOrderTaskVO> page, WareOrderTaskVO wareOrderTask);

}
