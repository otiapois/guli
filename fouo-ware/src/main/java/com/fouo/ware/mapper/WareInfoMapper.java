package com.fouo.ware.mapper;

import com.fouo.ware.entity.WareInfo;
import com.fouo.ware.vo.WareInfoVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 仓库信息 Mapper 接口
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface WareInfoMapper extends BaseMapper<WareInfo> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param wareInfo
	 * @return
	 */
	List<WareInfoVO> selectWareInfoPage(IPage page, WareInfoVO wareInfo);

}
