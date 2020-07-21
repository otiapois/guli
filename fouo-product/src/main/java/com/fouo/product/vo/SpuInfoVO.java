package com.fouo.product.vo;

import com.fouo.product.entity.SpuInfo;
import com.fouo.product.vo.ext.BaseAttrs;
import com.fouo.product.vo.ext.Bounds;
import com.fouo.product.vo.ext.Skus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import java.util.List;
/**
 * spu信息视图实体类
 * @author fouo
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SpuInfoVO对象", description = "spu信息")
public class SpuInfoVO extends SpuInfo {
	private static final long serialVersionUID = 1L;
	/**
	 * 关键字
	 */
	@ApiModelProperty(value = "关键字")
	private String searchKeyword;
	/**
	 * 描述分组
	 */
	@ApiModelProperty(value = "描述分组")
	private List<String> decript;
	/**
	 * 图片分组
	 */
	@ApiModelProperty(value = "图片分组")
	private List<String> images;
	/**
	 * 积分
	 */
	@ApiModelProperty(value = "积分")
	private Bounds bounds;
	/**
	 * 基本属性列表
	 */
	@ApiModelProperty(value = "基本属性列表")
	private List<BaseAttrs> baseAttrs;
	/**
	 * sku列表
	 */
	@ApiModelProperty(value = "sku列表")
	private List<Skus> skus;
}
