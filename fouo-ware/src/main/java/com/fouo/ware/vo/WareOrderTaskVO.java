package com.fouo.ware.vo;

import com.fouo.ware.entity.WareOrderTask;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 库存工作单视图实体类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "WareOrderTaskVO对象", description = "库存工作单")
public class WareOrderTaskVO extends WareOrderTask {
	private static final long serialVersionUID = 1L;

}
