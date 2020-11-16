package com.fouo.ware.mapper;

import com.fouo.ware.entity.WareOrderTask;
import com.fouo.ware.vo.WareOrderTaskVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 库存工作单 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface WareOrderTaskMapper extends BaseMapper<WareOrderTask> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param wareOrderTask
	 * @return
	 */
	List<WareOrderTaskVO> selectWareOrderTaskPage(IPage page, WareOrderTaskVO wareOrderTask);

}
