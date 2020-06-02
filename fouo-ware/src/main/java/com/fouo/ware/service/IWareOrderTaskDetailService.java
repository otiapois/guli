package com.fouo.ware.service;

import com.fouo.ware.entity.WareOrderTaskDetail;
import com.fouo.ware.vo.WareOrderTaskDetailVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 库存工作单 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IWareOrderTaskDetailService extends IService<WareOrderTaskDetail> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param wareOrderTaskDetail
	 * @return
	 */
	IPage<WareOrderTaskDetailVO> selectWareOrderTaskDetailPage(IPage<WareOrderTaskDetailVO> page, WareOrderTaskDetailVO wareOrderTaskDetail);

}
