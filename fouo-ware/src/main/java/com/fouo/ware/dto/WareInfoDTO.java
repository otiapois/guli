package com.fouo.ware.dto;

import com.fouo.ware.entity.WareInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 仓库信息数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WareInfoDTO extends WareInfo {
	private static final long serialVersionUID = 1L;

}
