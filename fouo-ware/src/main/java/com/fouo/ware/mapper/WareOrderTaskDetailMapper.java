package com.fouo.ware.mapper;

import com.fouo.ware.entity.WareOrderTaskDetail;
import com.fouo.ware.vo.WareOrderTaskDetailVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 库存工作单 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface WareOrderTaskDetailMapper extends BaseMapper<WareOrderTaskDetail> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param wareOrderTaskDetail
	 * @return
	 */
	List<WareOrderTaskDetailVO> selectWareOrderTaskDetailPage(IPage page, WareOrderTaskDetailVO wareOrderTaskDetail);

}
