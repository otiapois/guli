package com.fouo.ware.dto;

import com.fouo.ware.entity.WareOrderTask;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 库存工作单数据传输对象实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WareOrderTaskDTO extends WareOrderTask {
	private static final long serialVersionUID = 1L;

}
