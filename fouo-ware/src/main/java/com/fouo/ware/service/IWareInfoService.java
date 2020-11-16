package com.fouo.ware.service;

import com.fouo.ware.entity.WareInfo;
import com.fouo.ware.vo.WareInfoVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 仓库信息 服务类
 *
 * @author fouo
 * @since 2020-06-02
 */
public interface IWareInfoService extends IService<WareInfo> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param wareInfo
	 * @return
	 */
	IPage<WareInfoVO> selectWareInfoPage(IPage<WareInfoVO> page, WareInfoVO wareInfo);

}
